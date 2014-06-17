/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import eventoscientificos.Autor;
import eventoscientificos.Empresa;
import eventoscientificos.Evento;
import eventoscientificos.Topico;
import eventoscientificos.Utilizador;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pedro
 */
public class SubmeterArtigoControllerTest {

    private SubmeterArtigoController submeterArtigoController;
    private Empresa empresa;
    private Evento evento;
    private Utilizador utilizador;
    private Autor autor;

    public SubmeterArtigoControllerTest() {
        this.empresa = new Empresa();
        this.utilizador = new Utilizador("Wolverine", "Wolverine", 
                "xmen", "wolverine@xmen.com");
        this.empresa.getM_registaUtilizador().addUtilizador(utilizador);
        this.evento = new Evento("Teste", "Evento de teste");
        this.evento.addTopico(null);
        Topico topico = new Topico();
        topico.setCodigoACM("A1");
        topico.setDescricao("GENERAL INTRODUCTORY AND SURVEY");
        this.empresa.getM_registoEventos().registaEvento(evento);
        this.submeterArtigoController = new SubmeterArtigoController(empresa);
        
    }

    @Before
    public void setUp() {
        
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of iniciarSubmissao method, of class SubmeterArtigoController.
     */
    @Test
    public void testIniciarSubmissao() {
        System.out.println("iniciarSubmissao");
        SubmeterArtigoController instance = new SubmeterArtigoController(empresa);
        List<Evento> expResult = this.submeterArtigoController.iniciarSubmissao();
        List<Evento> result = instance.iniciarSubmissao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of selectEvento method, of class SubmeterArtigoController.
     */
    @Test
    public void testSelectEvento() {
        System.out.println("selectEvento");
        this.submeterArtigoController.selectEvento(this.evento);
        String[] e = submeterArtigoController.getListaEventosPodeSub();

        SubmeterArtigoController instance = new SubmeterArtigoController(empresa);
        instance.selectEvento(evento);
        String[] expResult = this.submeterArtigoController.getListaEventosPodeSub();
        String[] result = instance.getListaEventosPodeSub();
        Assert.assertArrayEquals(expResult, result);
    }

    /**
     * Test of getTopicosEvento method, of class SubmeterArtigoController.
     */
    @Test
    public void testGetTopicosEvento() {
        System.out.println("getTopicosEvento");
        SubmeterArtigoController instance = new SubmeterArtigoController(empresa);
        List<Topico> expResult = this.submeterArtigoController.getTopicosEvento();
        List<Topico> result = instance.getTopicosEvento();
        assertEquals(expResult, result);
    }

    /**
     * Test of novoAutor method, of class SubmeterArtigoController.
     */
    @Test
    public void testNovoAutor_String_String() {
        System.out.println("novoAutor");
        String strNome = "Wolverine";
        String strAfiliacao = "ISEP";
        String strEmail = "wolverine@xmen.com";
        SubmeterArtigoController instance = new SubmeterArtigoController(empresa);
        instance.selectEvento(evento);
        instance.iniciarSubmissao();
        Autor expResult = new Autor();
        expResult.setNome(strNome);
        expResult.setAfiliacao(strAfiliacao);
        expResult.setEMail(strEmail);
        Autor result = instance.novoAutor(strNome, strAfiliacao, strEmail);
        assertEquals(expResult, result);
    }


    /**
     * Test of addAutor method, of class SubmeterArtigoController.
     */
    @Test
    public void testAddAutor() {
        System.out.println("addAutor");
        Autor autor = new Autor();
        autor.setUtilizador(utilizador);
        SubmeterArtigoController instance = new SubmeterArtigoController(empresa);
        instance.selectEvento(evento);
        instance.iniciarSubmissao();
        boolean expResult = true;
        boolean result = instance.addAutor(autor);
        assertEquals(expResult, result);
    }

    /**
     * Test of getPossiveisAutoresCorrespondentes method, of class
     * SubmeterArtigoController.
     */
    @Test
    public void testGetPossiveisAutoresCorrespondentes() {
        System.out.println("getPossiveisAutoresCorrespondentes");
        SubmeterArtigoController instance = new SubmeterArtigoController(empresa);
        instance.selectEvento(evento);
        instance.iniciarSubmissao();
        Autor autorTeste = new Autor();
        autorTeste.setM_Utilizador(utilizador);
        instance.addAutor(autorTeste);
        List<Autor> expResult = new ArrayList<>();
        expResult.add(autorTeste);
        List<Autor> result = instance.getPossiveisAutoresCorrespondentes();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFicheiro method, of class SubmeterArtigoController.
     */
    @Test
    public void testSetFicheiro() {
        System.out.println("setFicheiro");
        String strFicheiro = "teste.pdf";
        SubmeterArtigoController instance = new SubmeterArtigoController(empresa);
        instance.selectEvento(evento);
        instance.iniciarSubmissao();
        instance.setFicheiro(strFicheiro);
        String expResult = strFicheiro;
        String result = instance.getM_artigo().getM_strFicheiro();
        assertEquals(expResult, result);
    }

    /**
     * Test of getInfoResumo method, of class SubmeterArtigoController.
     */
    @Test
    public void testGetInfoResumo() {
        System.out.println("getInfoResumo");
        SubmeterArtigoController instance = this.submeterArtigoController;
        instance.selectEvento(evento);
        instance.iniciarSubmissao();
        this.submeterArtigoController.selectEvento(evento);
        this.submeterArtigoController.iniciarSubmissao();
        this.submeterArtigoController.novoAutor("Wolverine", "ISEP", 
                "wolverine@xmen.com");
        String expResult = this.submeterArtigoController.getM_submissao().toString()+
                this.submeterArtigoController.getM_artigo().toString();
        String result = instance.getInfoResumo();
        assertEquals(expResult, result);
    }

    /**
     * Test of registarSubmissao method, of class SubmeterArtigoController.
     */
    @Test
    public void testRegistarSubmissao() {
        System.out.println("registarSubmissao");
        SubmeterArtigoController instance = null;
        boolean expResult = false;
        boolean result = instance.registarSubmissao();
        assertEquals(expResult, result);
    }

    
    /**
     * Test of getListaEventosPodeSub method, of class SubmeterArtigoController.
     */
    @Test
    public void testGetListaEventosPodeSub() {
        System.out.println("getListaEventosPodeSub");
        SubmeterArtigoController instance = null;
        String[] expResult = null;
        String[] result = instance.getListaEventosPodeSub();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listaAutores method, of class SubmeterArtigoController.
     */
    @Test
    public void testListaAutores() {
        System.out.println("listaAutores");
        Empresa empresa = null;
        SubmeterArtigoController instance = null;
        String[] expResult = null;
        String[] result = instance.listaAutores(empresa);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obterAutor method, of class SubmeterArtigoController.
     */
    @Test
    public void testObterAutor() {
        System.out.println("obterAutor");
        String autor = "";
        SubmeterArtigoController instance = null;
        Utilizador expResult = null;
        Utilizador result = instance.obterAutor(autor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
