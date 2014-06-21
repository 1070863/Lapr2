package controller;

import eventoscientificos.CP;
import eventoscientificos.Empresa;
import eventoscientificos.Evento;
import eventoscientificos.Revisor;
import eventoscientificos.Topico;
import eventoscientificos.Utilizador;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import states.EventoRegistadoState;

/**
 * Classe de teste à classe DefinirValoresRegistoController.
 *
 * @author GRUPO66 LAPR2
 */
public class DefinirValoresRegistoControllerTest {

    private Empresa m_empresa;
    private Evento m_evento;
    private CP m_cp;
    private Utilizador m_utilizador;
    private DefinirValoresRegistoController m_controllerDVR;
    private List<Evento> m_listEventos;
    private List<Topico> m_listTopicos;
    private Topico m_topico;
    private Revisor m_revisor;

    public DefinirValoresRegistoControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.m_empresa = new Empresa();
        this.m_evento = new Evento("cc", "cc");
        this.m_controllerDVR = new DefinirValoresRegistoController(this.m_empresa);
        this.m_utilizador = new Utilizador("nome", "user", "", "mail@qqq.pt");
        this.m_empresa.getM_registaUtilizador().addUtilizador(this.m_utilizador);
        this.m_listEventos = new ArrayList<>();
        this.m_empresa.getM_registoEventos().registaEvento(this.m_evento);
        this.m_controllerDVR.selectEvento(this.m_evento);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getEventosOrganizador method, of class
     * DefinirValoresRegistoController.
     */
    @Test
    public void testGetEventosOrganizador() {
        System.out.println("getEventosOrganizador");
        String strId = "user";
        this.m_evento.addOrganizador(strId, this.m_utilizador);
        this.m_empresa.getM_registoEventos().registaEvento(this.m_evento);
        this.m_listEventos.add(this.m_evento);
        List<Evento> expResult = this.m_empresa.getM_registoEventos().getEventosOrganizador(strId);
        List<Evento> result = this.m_controllerDVR.getEventosOrganizador(strId);
        assertEquals(expResult, result);
    }

    /**
     * Test of defineValorFP method, of class DefinirValoresRegistoController.
     */
    @Test
    public void testDefineValorFP() {
        System.out.println("defineValorFP");
        double fullPaper = 2.6;
        this.m_controllerDVR.defineValorFP(fullPaper);
        this.m_controllerDVR.selectEvento(this.m_evento);
        double expResult = fullPaper;
        double result = this.m_evento.getM_registoNoEvento().getPriceFP();
    }

    /**
     * Test of defineValorSP method, of class DefinirValoresRegistoController.
     */
    @Test
    public void testDefineValorSP() {
        System.out.println("defineValorSP");
        double shortPaper = 5.6;
        this.m_controllerDVR.defineValorSP(shortPaper);
        this.m_controllerDVR.selectEvento(this.m_evento);
        double expResult = shortPaper;
        double result = this.m_evento.getM_registoNoEvento().getPriceSP();
    }

    /**
     * Test of defineValorPP method, of class DefinirValoresRegistoController.
     */
    @Test
    public void testDefineValorPP() {
        System.out.println("defineValorPP");
        double posterPaper = 7.65;
        this.m_controllerDVR.defineValorPP(posterPaper);
        this.m_controllerDVR.selectEvento(this.m_evento);
        double expResult = posterPaper;
        double result = this.m_evento.getM_registoNoEvento().getPricePP();
    }

    /**
     * Test of defineFormula1 method, of class DefinirValoresRegistoController.
     */
    @Test
    public void testDefineFormula1() {
        System.out.println("defineFormula1");
        int numFullPaper = 1;
        int numPosterPaper = 1;
        int numShortPaper = 1;
        this.m_controllerDVR.defineValorPP(5);
        this.m_controllerDVR.defineValorSP(5);
        this.m_controllerDVR.defineValorFP(5);
        this.m_controllerDVR.defineFormula1();
        this.m_controllerDVR.selectEvento(this.m_evento);
        this.m_evento.getM_registoNoEvento().setPagamentoRegFormual1(this.m_evento);
        double expResult = 15;
        double result =this.m_evento.getM_registoNoEvento().getPagamentoReg().calculaValor(numFullPaper,
                numPosterPaper, numShortPaper);
    }

    /**
     * Test of defineFormula2 method, of class DefinirValoresRegistoController.
     */
    @Test
    public void testDefineFormula2() {
        System.out.println("defineFormula2");
        int numFullPaper = 3;
        int numPosterPaper = 2;
        int numShortPaper = 0;
        this.m_controllerDVR.defineValorPP(20);
        this.m_controllerDVR.defineValorSP(5);
        this.m_controllerDVR.defineValorFP(12.5);
        this.m_controllerDVR.defineFormula1();
        this.m_controllerDVR.selectEvento(this.m_evento);
        this.m_evento.getM_registoNoEvento().setPagamentoRegFormual2(this.m_evento);
        double expResult = 47.5;
        double result =this.m_evento.getM_registoNoEvento().getPagamentoReg().calculaValor(numFullPaper,
                numPosterPaper, numShortPaper);
    }

    /**
     * Test of termina method, of class DefinirValoresRegistoController.
     */
    @Test
    public void testTermina() {
        System.out.println("termina");
        this.m_evento.setState(new EventoRegistadoState(this.m_evento));
        this.m_evento.getM_registoNoEvento().setPagamentoRegFormual1(this.m_evento);
        this.m_evento.getM_registoNoEvento().setPriceFP(2);
        this.m_evento.getM_registoNoEvento().setPriceSP(2);
        this.m_evento.getM_registoNoEvento().setPricePP(2);
        boolean expResult = true;
        boolean result = this.m_controllerDVR.termina();
        assertEquals(expResult, result);
    }

}
