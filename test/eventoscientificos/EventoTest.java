/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eventoscientificos;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import states.EventoState;

/**
 *
 * @author Lopes
 */
public class EventoTest {
    
    private static Evento instance;
    private static CP cp;
    private static ProcessoDistribuicao processoDistribuicao;
    private static Utilizador utilizador;
    private static Submissao submissao;
    private static List<Topico> listaTopicos;
    private static Organizador organizador;
    private static Topico topico;
    private static EventoState eventoState;
    private static Local local;
    
    public EventoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        instance = new Evento();
        instance.setTitulo("TituloEvento");
        cp=new CP();
        processoDistribuicao= new ProcessoDistribuicao();
        utilizador = new Utilizador("Utilizador 1", "ut1", "111", "ut1@isep.pt");
        submissao = new Submissao();
        listaTopicos=new ArrayList<>();
        organizador = new Organizador();
        topico=new Topico();
        local=new Local();
        local.setM_strLocal("pavilhão");

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
     * Test of novaCP method, of class Evento.
     */
    @Test
    public void testNovaCP() {
        System.out.println("novaCP");
        CP expResult = cp;
        CP result = instance.novaCP();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getDataLimiteRevisao method, of class Evento.
     */
    @Test
    public void testGetDataLimiteRevisao() {
        System.out.println("getDataLimiteRevisao");
        instance.setDataLimiteRevisao("18 de Dezembro de 2013");
        String expResult = "18 de Dezembro de 2013";
        String result = instance.getDataLimiteRevisao();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProcessoDistribuicao method, of class Evento.
     */
    @Test
    public void testGetProcessoDistribuicao() {
        System.out.println("getProcessoDistribuicao");
        instance.setProcessoDistribuicao(processoDistribuicao);
        ProcessoDistribuicao expResult = processoDistribuicao;
        ProcessoDistribuicao result = instance.getProcessoDistribuicao();
        assertEquals(expResult, result);
    }

    /**
     * Test of novoProcessoDistribuicao method, of class Evento.
     */
    @Test
    public void testNovoProcessoDistribuicao() {
        System.out.println("novoProcessoDistribuicao");
        ProcessoDistribuicao expResult = processoDistribuicao;
        ProcessoDistribuicao result = instance.novoProcessoDistribuicao();
        assertEquals(expResult, result);
    }

//    /**
//     * Test of getListaOrganizadores method, of class Evento.
//     */
//    @Test
//    public void testGetListaOrganizadores() {
//        System.out.println("getListaOrganizadores");
//        List<Organizador> expResult = new ArrayList<>();
//        organizador.setM_utilizador(utilizador);
//        expResult.add(organizador);
//        List<Organizador> result = instance.getListaOrganizadores();
//        assertEquals(expResult, result);
//    }

    /**
     * Test of addOrganizador method, of class Evento.
     */
    @Test
    public void testAddOrganizador() {
        System.out.println("addOrganizador");
        String strId = "ut1";       
        boolean expResult = true;
        boolean result = instance.addOrganizador(strId, utilizador);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Evento.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "TituloEvento+ ...";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCP method, of class Evento.
     */
    @Test
    public void testGetCP() {
        System.out.println("getCP");
        instance.setCP(cp);
        CP expResult = cp;
        CP result = instance.getCP();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTopicos method, of class Evento.
     */
    @Test
    public void testGetTopicos() {
        System.out.println("getTopicos");
        instance.setM_listaTopicos(listaTopicos);
        List<Topico> expResult = listaTopicos;
        List<Topico> result = instance.getTopicos();
        assertEquals(expResult, result);
    }

    /**
     * Test of novoTopico method, of class Evento.
     */
    @Test
    public void testNovoTopico() {
        System.out.println("novoTopico");
        Topico expResult = topico;
        Topico result = instance.novoTopico();
        assertEquals(expResult, result);
    }

    /**
     * Test of addTopico method, of class Evento.
     */
    @Test
    public void testAddTopico() {
        System.out.println("addTopico");
        Topico t = topico;
        boolean expResult = true;
        boolean result = instance.addTopico(t);
        assertEquals(expResult, result);
    }

    /**
     * Test of validaTopico method, of class Evento.
     */
    @Test
    public void testValidaTopico() {
        System.out.println("validaTopico");
        Topico t = topico;
        boolean expResult = true;
        boolean result = instance.validaTopico(t);
        assertEquals(expResult, result);
    }

    /**
     * Test of getState method, of class Evento.
     */
    @Test
    public void testGetState() {
        System.out.println("getState");
        instance.setState(eventoState);
        EventoState expResult = eventoState;
        EventoState result = instance.getState();
        assertEquals(expResult, result);
    }

    /**
     * Test of getM_strTitulo method, of class Evento.
     */
    @Test
    public void testGetM_strTitulo() {
        System.out.println("getM_strTitulo");
        String expResult = "TituloEvento";
        String result = instance.getM_strTitulo();
        assertEquals(expResult, result);
    }

    /**
     * Test of getM_strDescricao method, of class Evento.
     */
    @Test
    public void testGetM_strDescricao() {
        System.out.println("getM_strDescricao");
        instance.setDescricao("Descrição Evento");
        String expResult = "Descrição Evento";
        String result = instance.getM_strDescricao();
        assertEquals(expResult, result);
    }

    /**
     * Test of getM_local method, of class Evento.
     */
    @Test
    public void testGetM_local() {
        System.out.println("getM_local");
        instance.setLocal("pavilhão");
        Local expResult = local;
        Local result = instance.getM_local();
        assertEquals(expResult, result);
    }

    /**
     * Test of getM_strDataInicio method, of class Evento.
     */
    @Test
    public void testGetM_strDataInicio() {
        System.out.println("getM_strDataInicio");
        instance.setDataInicio("18 de Dezembro 2014");
        String expResult = "18 de Dezembro 2014";
        String result = instance.getM_strDataInicio();
        assertEquals(expResult, result);
    }

    /**
     * Test of getM_strDataFim method, of class Evento.
     */
    @Test
    public void testGetM_strDataFim() {
        System.out.println("getM_strDataFim");
        instance.setDataFim("18 de Dezembro 2014");
        String expResult = "18 de Dezembro 2014";
        String result = instance.getM_strDataFim();
        assertEquals(expResult, result);
    }

    /**
     * Test of getnMaxTopicos method, of class Evento.
     */
    @Test
    public void testGetnMaxTopicos() {
        System.out.println("getnMaxTopicos");
        instance.setnMaxTopicos(5);
        int expResult = 5;
        int result = instance.getnMaxTopicos();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDataLimiteRegisto method, of class Evento.
     */
    @Test
    public void testGetDataLimiteRegisto() {
        System.out.println("getDataLimiteRegisto");
        instance.setDataLimiteRegisto("18 de Dezembro 2014");
        String expResult = "18 de Dezembro 2014";
        String result = instance.getDataLimiteRegisto();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Evento.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = instance;
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of getM_listaTopicos method, of class Evento.
     */
    @Test
    public void testGetM_listaTopicos() {
        System.out.println("getM_listaTopicos");
        instance.setM_listaTopicos(listaTopicos);
        List<Topico> expResult = listaTopicos;
        List<Topico> result = instance.getM_listaTopicos();
        assertEquals(expResult, result);
    }
    
}
