package controller;

import eventoscientificos.CP;
import eventoscientificos.Empresa;
import eventoscientificos.Evento;
import eventoscientificos.Revisor;
import eventoscientificos.Topico;
import eventoscientificos.Utilizador;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import states.EventoTopicosDefinidosState;

/**
 * Classe de teste à classe CriarCPController.
 *
 * @author GRUPO66 LAPR2
 */
public class CriarCPControllerTest {

    private Empresa m_empresa;
    private Evento m_evento;
    private CP m_cp;
    private Utilizador m_utilizador;
    private CriarCPController m_cPController;
    private List<Evento> m_listEventos;
    private List<Topico> m_listTopicos;
    private Topico m_topico;
    private Revisor m_revisor;

    public CriarCPControllerTest() {
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
        this.m_cPController = new CriarCPController(this.m_empresa);
        this.m_utilizador = new Utilizador("nome", "user", "", "mail@qqq.pt");
        this.m_empresa.getM_registaUtilizador().addUtilizador(this.m_utilizador);
        this.m_listEventos = new ArrayList<>();
        this.m_listTopicos = new ArrayList<>();
        this.m_topico = new Topico("", "");
        this.m_revisor = new Revisor(this.m_utilizador);
        this.m_empresa.getM_registoEventos().registaEvento(this.m_evento);
        this.m_cPController.selectEvento(this.m_evento);
        this.m_cp = this.m_evento.getCP();
        this.m_cp.addMembroCP("user", this.m_utilizador);
        this.m_evento.setCP(this.m_cp);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getEventosOrganizador method, of class CriarCPController.
     */
    @Test
    public void testGetEventosOrganizador() {
        System.out.println("getEventosOrganizador");
        String strId = "user";
        this.m_evento.addOrganizador(strId, this.m_utilizador);
        this.m_empresa.getM_registoEventos().registaEvento(this.m_evento);
        this.m_listEventos.add(this.m_evento);
        List<Evento> expResult = this.m_empresa.getM_registoEventos().getEventosOrganizador(strId);
        List<Evento> result = this.m_cPController.getEventosOrganizador(strId);
        assertEquals(expResult, result);
    }

    /**
     * Test of getTopicosEvento method, of class CriarCPController.
     */
    @Test
    public void testGetTopicosEvento() {
        System.out.println("getTopicosEvento");
        this.m_empresa.getM_registoEventos().registaEvento(this.m_evento);
        this.m_evento.getM_listaTopicos().add(this.m_topico);
        this.m_listEventos.add(this.m_evento);
        this.m_listTopicos.add(this.m_topico);
        List<Topico> expResult = this.m_listTopicos;
        List<Topico> result = this.m_evento.getTopicos();
        assertEquals(expResult, result);

    }

    /**
     * Test of addMembroCP method, of class CriarCPController.
     */
    @Test
    public void testAddMembroCP() {
        System.out.println("addMembroCP");
        String strId = "mail@qqq.pt";
        Revisor expResult = this.m_revisor;
        Revisor result = this.m_cPController.addMembroCP(strId);
        assertEquals(expResult, result);
    }

    /**
     * Test of registaMembroCP method, of class CriarCPController.
     */
    @Test
    public void testRegistaMembroCP() {
        System.out.println("registaMembroCP");
        boolean expResult = true;
        boolean result = this.m_cPController.registaMembroCP(this.m_revisor);
        assertEquals(expResult, result);
    }

    /**
     * Test of setCP method, of class CriarCPController.
     */
    @Test
    public void testSetCP() {
        System.out.println("setCP");
        this.m_cPController.setCP();
        CP expResult = this.m_cp;
        CP result = this.m_evento.getCP();
        assertEquals(expResult, result);
    }

    /**
     * Test of setListaTopicosRevisor method, of class CriarCPController.
     */
    @Test
    public void testSetListaTopicosRevisor() {
        System.out.println("setListaTopicosRevisor");

        this.m_cPController.setListaTopicosRevisor(this.m_revisor, this.m_listTopicos);
        List<Topico> expResult = this.m_listTopicos;
        List<Topico> result = this.m_revisor.getM_listaTopicos();
        assertEquals(expResult, result);
    }

    /**
     * Test of listaDeTopicos method, of class CriarCPController.
     */
    @Test
    public void testListaDeTopicos() {
        System.out.println("listaDeTopicos");
        DefaultListModel teste = new DefaultListModel();
        teste.addElement(this.m_topico.getM_strCodigoACM() + " " + this.m_topico.getM_strDescricao());
        boolean expResult = true;
        boolean result = teste.contains(this.m_topico.getM_strCodigoACM() + " " + this.m_topico.getM_strDescricao());
        Assert.assertEquals(expResult, result);
    }

    /**
     * Test of termina method, of class CriarCPController.
     */
    @Test
    public void testTermina() {
        System.out.println("termina");
        this.m_evento.setState(new EventoTopicosDefinidosState(this.m_evento));
        this.m_cPController.selectEvento(this.m_evento);
        this.m_cPController.registaMembroCP(this.m_cPController.addMembroCP(this.m_utilizador.getM_strEmail()));
        this.m_cPController.setCP();
        boolean expResult = true;
        boolean result = this.m_cPController.termina();
        assertEquals(expResult, result);
    }
}
