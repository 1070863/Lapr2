/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import eventoscientificos.Artigo;
import eventoscientificos.Distribuicao;
import eventoscientificos.Empresa;
import eventoscientificos.Evento;
import eventoscientificos.Revisor;
import eventoscientificos.Utilizador;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import states.EventoDistribuidoState;

/**
 *
 * @author Pedro
 */
public class RevisaoArtigoControllerTest {
    Empresa empresa;
    List<Artigo> artigos;
    
    public RevisaoArtigoControllerTest() {
        this.empresa=new Empresa();
        artigos=new ArrayList<>();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Artigo a1 = new Artigo();
        a1.setTitulo("Artigo");
        a1.setTipo("Full paper");
        a1.setFicheiro("teste.pdf");
        artigos.add(a1);
        Evento e = new Evento("Teste", "Teste");
        e.setState(new EventoDistribuidoState(e));
        Revisor revisor = new Revisor(new Utilizador("nome", "username", "pass", "user@mail.pt"));
        List<Revisor> listaRevisores = new ArrayList<>();
        Distribuicao distribuicao = new Distribuicao(listaRevisores, a1);
        empresa.getM_registoEventos().novoEvento().novoProcessoDistribuicao();
        empresa.getM_registoEventos().registaEvento(e);
        //empresa.getM_registoEventos().getEvento("teste").novoProcessoDistribuicao();
        //empresa.getM_registoEventos().getEvento("teste").getProcessoDistribuicao().;
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getListaEventosPodeRever method, of class RevisaoArtigoController.
     */
    @Test
    public void testGetListaEventosPodeRever() {
        System.out.println("getListaEventosPodeRever");
        String organizador = "";
        RevisaoArtigoController instance = null;
        List<Evento> expResult = null;
        List<Evento> result = instance.getListaEventosPodeRever(organizador);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of seleccionaEvento method, of class RevisaoArtigoController.
     */
    @Test
    public void testSeleccionaEvento() {
        System.out.println("seleccionaEvento");
        String evento = "";
        RevisaoArtigoController instance = null;
        instance.seleccionaEvento(evento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaArtigos method, of class RevisaoArtigoController.
     */
    @Test
    public void testGetListaArtigos() {
        System.out.println("getListaArtigos");
        RevisaoArtigoController instance = new RevisaoArtigoController(this.empresa);
        
        List<Artigo> expResult = this.artigos;
        List<Artigo> result = instance.getListaArtigos();
       assertEquals(expResult, result);
    }

    /**
     * Test of sleccionaArtigo method, of class RevisaoArtigoController.
     */
    @Test
    public void testSleccionaArtigo() {
        System.out.println("sleccionaArtigo");
        String artigo = "";
        RevisaoArtigoController instance = null;
        instance.sleccionaArtigo(artigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of seleccionaSubmissao method, of class RevisaoArtigoController.
     */
    @Test
    public void testSeleccionaSubmissao() {
        System.out.println("seleccionaSubmissao");
        Artigo artigo = null;
        RevisaoArtigoController instance = null;
        instance.seleccionaSubmissao(artigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registaRevisao method, of class RevisaoArtigoController.
     */
    @Test
    public void testRegistaRevisao() {
        System.out.println("registaRevisao");
        String confianca = "";
        String adequacao = "";
        String originalidade = "";
        String qualidade = "";
        boolean recomendacao = false;
        String texto = "";
        RevisaoArtigoController instance = null;
        boolean expResult = false;
        boolean result = instance.registaRevisao(confianca, adequacao, originalidade, qualidade, recomendacao, texto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
