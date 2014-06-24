/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import eventoscientificos.Autor;
import eventoscientificos.Empresa;
import eventoscientificos.Evento;
import eventoscientificos.Submissao;
import eventoscientificos.Utilizador;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import states.SubmissaoAceiteState;
import states.SubmissaoRejeitadaState;

/**
 * Esta classe serve de teste à classe RegistNoEventoController.
 *
 * @author GRUPO66 LAPR2
 */
public class RegistoNoEventoControllerTest {

    private Empresa m_empresa;
    private Autor m_autor;
    private Evento m_evento;
    private List<Evento> m_listEventos;
    private Submissao m_submissao1;
    private Submissao m_submissao2;
    private Submissao m_submissao3;
    private RegistoNoEventoController m_controllerRNE;
    private Utilizador m_utilizador;
    

    public RegistoNoEventoControllerTest() {
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
        this.m_empresa.getM_registaUtilizador().addUtilizador(this.m_utilizador);
        this.m_evento = new Evento("Event", "testEvent");
        this.m_listEventos = new ArrayList<>();
        this.m_utilizador = new Utilizador("nome", "user", "", "email@mail,pt");
        this.m_submissao1 = new Submissao();
        this.m_submissao2 = new Submissao();
        this.m_submissao3 = new Submissao();
        this.m_autor= new Autor();
        this.m_autor.setM_Utilizador(this.m_utilizador);
        
        this.m_submissao1.getArtigo().setAutorCorrespondente(this.m_autor);
        this.m_submissao2.getArtigo().setAutorCorrespondente(this.m_autor);
        this.m_submissao2.getArtigo().setAutorCorrespondente(this.m_autor);
       
        this.m_submissao1.setState(new SubmissaoRejeitadaState(this.m_submissao1));
        this.m_submissao2.setState(new SubmissaoRejeitadaState(this.m_submissao2));
        this.m_submissao3.setState(new SubmissaoAceiteState(this.m_submissao3));
        
        this.m_evento.addSubmissao(m_submissao1);
        this.m_evento.addSubmissao(m_submissao2);
        this.m_evento.addSubmissao(m_submissao3);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getEventosAutorSubAceites method, of class
     * RegistoNoEventoController.
     */
    @Test
    public void testGetEventosAutorSubAceites() {
        System.out.println("getEventosAutorSubAceites");
        String strId = "user";
        this.m_listEventos.add(this.m_evento);
        List<Evento> expResult = this.m_listEventos;
        List<Evento> result = this.m_controllerRNE.getEventosAutorSubAceites(strId);
        assertEquals(expResult, result);
    }

    /**
     * Test of selectEvento method, of class RegistoNoEventoController.
     */
    @Test
    public void testSelectEvento() {
        System.out.println("selectEvento");
        Evento e = null;
        RegistoNoEventoController instance = null;
        instance.selectEvento(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculaValor method, of class RegistoNoEventoController.
     */
    @Test
    public void testCalculaValor() {
        System.out.println("calculaValor");
        String id = "";
        RegistoNoEventoController instance = null;
        double expResult = 0.0;
        double result = instance.calculaValor(id);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of adicionaRegisto method, of class RegistoNoEventoController.
     */
    @Test
    public void testAdicionaRegisto() {
        System.out.println("adicionaRegisto");
        RegistoNoEventoController instance = null;
        boolean expResult = false;
        boolean result = instance.adicionaRegisto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of termina method, of class RegistoNoEventoController.
     */
    @Test
    public void testTermina() {
        System.out.println("termina");
        RegistoNoEventoController instance = null;
        boolean expResult = false;
        boolean result = instance.termina();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of defineRegisto method, of class RegistoNoEventoController.
     */
    @Test
    public void testDefineRegisto() {
        System.out.println("defineRegisto");
        String metodoPagamento = "";
        String diaValidade = "";
        String mesValidade = "";
        String anoValidade = "";
        String diaLimite = "";
        String mesLimite = "";
        String anoLimite = "";
        float valor = 0.0F;
        String numeroCartao = "";
        RegistoNoEventoController instance = null;
        boolean expResult = false;
        boolean result = instance.defineRegisto(metodoPagamento, diaValidade, mesValidade, anoValidade, diaLimite, mesLimite, anoLimite, valor, numeroCartao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
