/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import eventoscientificos.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pereira
 */
public class DecidirSobreArtigosControllerTest {

    public DecidirSobreArtigosControllerTest() {
    }
    private Empresa m_empresa;
    private DecidirSobreArtigosController instance;
    private Evento m_evento;
    private ProcessoDecisao processoDecisao;
    private List<Decisao> listaDecisoes;
    private List<MecanismoDecisao> listaMecanismosDecisao;
    private List<Evento> listaEventosOrganizador;
    private Utilizador u;
    private Organizador org;
    private Topico topico;
    private String orgID;
    private Decisao decisao;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        m_empresa = new Empresa();
        orgID = "Pedro";
        u = m_empresa.getM_registaUtilizador().novoUtilizador();
        u.setM_strNome(orgID);
        u.setM_strPassword(orgID);
        u.setM_strUsername(orgID);
        u.setM_strEmail("pedro@mail.pt");
        org = new Organizador("Pedro", u);
        instance = new DecidirSobreArtigosController(m_empresa);
        m_evento = m_empresa.getM_registoEventos().novoEvento();
        m_evento.addOrganizador(orgID, u);
        m_evento.setLocal("Isep");
        topico = m_evento.novoTopico();
        m_evento.addTopico(topico);
        listaEventosOrganizador = m_empresa.getM_registoEventos().getEventosOrganizador(orgID);
        processoDecisao = m_evento.novoProcessoDecisao();
        processoDecisao.setM_decisao(decisao);
        listaDecisoes = processoDecisao.getM_listaDecisao();
        listaMecanismosDecisao = m_empresa.getM_registoEventos().criarListaMecanismoDecisao();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getM_evento method, of class DecidirSobreArtigosController.
     */
    @Test
    public void testGetM_evento() {
        System.out.println("getM_evento");
        instance.setM_evento(m_evento);
        Evento expResult = m_evento;
        Evento result = instance.getM_evento();
        assertEquals(expResult, result);
    }

    /**
     * Test of ListarEventosOrganizador method, of class
     * DecidirSobreArtigosController.
     */
    @Test
    public void testListarEventosOrganizador() {
        System.out.println("ListarEventosOrganizador");
        List<Evento> expResult = listaEventosOrganizador;
        List<Evento> result = instance.ListarEventosOrganizador(orgID);
        assertEquals(expResult, result);
    }

    /**
     * Test of getProcessoDecisao method, of class
     * DecidirSobreArtigosController.
     */
    @Test
    public void testGetProcessoDecisao() {
        System.out.println("getProcessoDecisao");
        instance.setProcessoDecisao(processoDecisao);
        ProcessoDecisao expResult = processoDecisao;
        ProcessoDecisao result = instance.getProcessoDecisao();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaMecanismosDecisao method, of class
     * DecidirSobreArtigosController.
     */
    @Test
    public void testGetListaMecanismosDecisao() {
        System.out.println("getListaMecanismosDecisao");
        instance.setListaMecanismosDecisao(listaMecanismosDecisao);
        List<MecanismoDecisao> expResult = listaMecanismosDecisao;
        List<MecanismoDecisao> result = instance.getListaMecanismosDecisao();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaDecisoes method, of class DecidirSobreArtigosController.
     */
    @Test
    public void testGetListaDecisoes() {
        System.out.println("getListaDecisoes");
        instance.setListaDecisoes(listaDecisoes);

        List<Decisao> expResult = listaDecisoes;
        List<Decisao> result = instance.getListaDecisoes();
        assertEquals(expResult, result);
    }
    /**
     * teste do metodo 
     */
    /**
     * Test of termina method, of class CriarCPController.
     */
    @Test
    public void testTermina() {
        System.out.println("termina");
        boolean expResult = true;
        boolean result = instance.termina();
        assertEquals(expResult, result);
    }
}
