package controller;

import eventoscientificos.Empresa;
import eventoscientificos.Evento;
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
 * Classe de teste à classe controller do UC9(Definição de Tópicos de Evento).
 *
 * @author GRUPO66 LAPR2
 */
public class DefinirTopicEventControllerTest {

    private Topico m_topico;
    private static Empresa m_empresa;
    private Utilizador m_utilizador;
    private List<Evento> m_listEventos;
    private List<Topico> m_listTopicos;
    private DefinirTopicEventController m_controllerDTE;
    private Evento m_evento;
    private String m_codigo;
    private String m_descricao;
    private static List<Evento> eventos;

    public DefinirTopicEventControllerTest() {
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
        this.m_controllerDTE = new DefinirTopicEventController(this.m_empresa);
        this.m_utilizador = new Utilizador("nome", "user", "", "mail@qqq.pt");
        this.m_empresa.getM_registaUtilizador().addUtilizador(this.m_utilizador);
        this.m_listEventos = new ArrayList<>();
        this.m_listTopicos = new ArrayList<>();
        this.m_topico = new Topico("", "");
        this.m_evento.setM_listaTopicos(this.m_listTopicos);
        this.m_evento.getM_listaTopicos().add(this.m_topico);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getEventosOrganizador method, of class
     * DefinirTopicEventController.
     */
    @Test
    public void testGetEventosOrganizador() {
        System.out.println("getEventosOrganizador");
        String strId = "user";
        this.m_evento.addOrganizador(strId, this.m_utilizador);
        this.m_empresa.getM_registoEventos().registaEvento(this.m_evento);
        this.m_listEventos.add(this.m_evento);
        List<Evento> expResult = this.m_empresa.getM_registoEventos().getEventosOrganizador(strId);
        List<Evento> result = this.m_controllerDTE.getEventosOrganizador(strId);
        assertEquals(expResult, result);
    }

//    /**
//     * Test of setEvento method, of class DefinirTopicEventController.
//     * Nota: Trata-se de uma atribuição simples a uma variável.
//     */
//    @Test
//    public void testSetEvento() {
//        System.out.println("setEvento");
//        Evento e = null;
//        DefinirTopicEventController instance = new DefinirTopicEventController();
//        instance.setEvento(e);
//    }
//    /**
//     * Test of procurarTopicoACM method, of class DefinirTopicEventController.
//     * Nota: Leitura de ficheiro XML.
//     */
//    @Test
//    public void testProcurarTopicoACM() throws Exception {
//        System.out.println("procurarTopicoACM");
//        String codeACM = "";
//        DefinirTopicEventController instance = new DefinirTopicEventController();
//        String expResult = "";
//        String result = instance.procurarTopicoACM(codeACM);
//        assertEquals(expResult, result);
//    }
    /**
     * Test of registaTopico method, of class DefinirTopicEventController.
     */
    @Test
    public void testRegistaTopico() {
        System.out.println("registaTopico");
        boolean expResult = true;
        boolean result = this.m_evento.getM_listaTopicos().add(this.m_topico);
        assertEquals(expResult, result);
    }

    /**
     * Test of termina method, of class DefinirTopicEventController.
     */
    @Test
    public void testTermina() {
        System.out.println("termina");
        this.m_evento.setState(new EventoRegistadoState(this.m_evento));
        this.m_evento.getM_listaTopicos().add(this.m_topico);
        boolean expResult = true;
        boolean result = this.m_evento.getState().valida();
        assertEquals(expResult, result);
    }

    /**
     * Test of validaTopico method, of class DefinirTopicEventController.
     */
    @Test
    public void testValidaTopico() {
        System.out.println("validaTopico");
        this.m_listTopicos.add(this.m_topico);
        this.m_evento.setM_listaTopicos(this.m_listTopicos);
        boolean result = false;
        for (Topico t : this.m_evento.getM_listaTopicos()) {
            if (t.equals(this.m_topico)) {
              result = true;
            }
        }
        boolean expResult = true;
        assertEquals(expResult, result);
    }
}
