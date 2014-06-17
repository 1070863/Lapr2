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

/**
 * Classe de teste à classe controller do UC9(Definição de Tópicos de Evento).
 *
 * @author GRUPO66 LAPR2
 */
public class DefinirTopicEventControllerTest {

    private Topico m_topico;
    private static Empresa m_empresa = new Empresa();
    private static Utilizador u;
    private Evento m_evento;
    private String m_codigo;
    private String m_descricao;
    private static List<Evento>eventos=new ArrayList<>();

    public DefinirTopicEventControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        Evento e = new Evento("ev1", "afoisaf");
        u = new Utilizador("SF", "u", "sfs", "hs@jdd.com");
        e.addOrganizador("sfs", u);
        m_empresa.getM_registaUtilizador().registaUtilizador(u);
        eventos.add(e);
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
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
        String strId = "";
        DefinirTopicEventController instance = new DefinirTopicEventController();
        List<Evento> expResult = eventos;
        List<Evento> result = instance.getEventosOrganizador(u.getM_strEmail());
        assertEquals(expResult, result);
    }
//
//    /**
//     * Test of setEvento method, of class DefinirTopicEventController.
//     */
//    @Test
//    public void testSetEvento() {
//        System.out.println("setEvento");
//        Evento e = null;
//        DefinirTopicEventController instance = new DefinirTopicEventController();
//        instance.setEvento(e);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of procurarTopicoACM method, of class DefinirTopicEventController.
//     */
//    @Test
//    public void testProcurarTopicoACM() throws Exception {
//        System.out.println("procurarTopicoACM");
//        String codeACM = "";
//        DefinirTopicEventController instance = new DefinirTopicEventController();
//        String expResult = "";
//        String result = instance.procurarTopicoACM(codeACM);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of registaTopico method, of class DefinirTopicEventController.
//     */
//    @Test
//    public void testRegistaTopico() {
//        System.out.println("registaTopico");
//        DefinirTopicEventController instance = new DefinirTopicEventController();
//        boolean expResult = false;
//        boolean result = instance.registaTopico();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of termina method, of class DefinirTopicEventController.
//     */
//    @Test
//    public void testTermina() {
//        System.out.println("termina");
//        DefinirTopicEventController instance = new DefinirTopicEventController();
//        boolean expResult = false;
//        boolean result = instance.termina();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of validaTopico method, of class DefinirTopicEventController.
//     */
//    @Test
//    public void testValidaTopico() {
//        System.out.println("validaTopico");
//        Topico topico = null;
//        DefinirTopicEventController instance = new DefinirTopicEventController();
//        boolean expResult = false;
//        boolean result = instance.validaTopico(topico);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

}
