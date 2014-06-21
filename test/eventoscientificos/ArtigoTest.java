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

/**
 *
 * @author amartins
 */
public class ArtigoTest {

    private List<Topico> topicos;

    public ArtigoTest() {
        topicos = new ArrayList<>();
        Topico topico1 = new Topico("A.1", "Teste");
        Topico topico2 = new Topico("A.2", "Teste");
        topicos.add(topico1);
        topicos.add(topico2);
    }

    @BeforeClass
    public static void setUpClass() {

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
     * Test of getConfianca method, of class Revisor.
     */
    @Test
    public void testGetConfianca() {
        System.out.println("getConfianca");
        Artigo instance = new Artigo();
        String expResult = "0";
        instance.setConfianca(expResult);
        String result = instance.getConfianca();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAdequacao method, of class Revisor.
     */
    @Test
    public void testGetAdequacao() {
        System.out.println("getAdequacao");
        Artigo instance = new Artigo();
        String expResult = "1";
        instance.setAdequacao(expResult);
        String result = instance.getAdequacao();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOriginalidade method, of class Revisor.
     */
    @Test
    public void testGetOriginalidade() {
        System.out.println("getOriginalidade");
        Artigo instance = new Artigo();
        String expResult = "2";
        instance.setOriginalidade(expResult);
        String result = instance.getOriginalidade();
        assertEquals(expResult, result);
    }

    /**
     * Test of getQualidade method, of class Revisor.
     */
    @Test
    public void testGetQualidade() {
        System.out.println("getQualidade");
        Artigo instance = new Artigo();
        String expResult = "3";
        instance.setQualidade(expResult);
        String result = instance.getQualidade();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRecomendacao method, of class Revisor.
     */
    @Test
    public void testGetRecomendacao() {
        System.out.println("getRecomendacao");
        Artigo instance = new Artigo();
        boolean expResult = true;
        instance.setRecomendacao(expResult);
        boolean result = instance.getRecomendacao();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTextoJustificativo method, of class Revisor.
     */
    @Test
    public void testGetTextoJustificativo() {
        System.out.println("getTextoJustificativo");
        Artigo instance = new Artigo();
        String expResult = "Teste texto";
        instance.setTextoJustificativo(expResult);
        String result = instance.getTextoJustificativo();
        assertEquals(expResult, result);
    }

    /**
     * Test of validaEmail method, of class Artigo.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        Artigo instance = new Artigo();
        boolean expResult = true;
        boolean result = instance.valida();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Artigo.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Artigo instance = new Artigo();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Artigo.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Utilizador myUt = new Utilizador();
        myUt.setM_strUsername("expert@isep.ipp.pt");
        myUt.setM_strEmail("expert@isep.ipp.pt");
        Autor act = new Autor();
        act.setUtilizador(myUt);

        Artigo obj = new Artigo();
        obj.setTitulo("A beleza do JUnit");
        obj.setAutorCorrespondente(act);
        Artigo instance = new Artigo();
        instance.setTitulo("A beleza do JUnit");
        instance.setAutorCorrespondente(act);

        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }


    /**
     * Test of getTitulo method, of class Artigo.
     */
    @Test
    public void testGetTitulo() {
        System.out.println("getTitulo");
        Artigo instance = new Artigo();
        String expResult = "";
        String result = instance.getTitulo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResumo method, of class Artigo.
     */
    @Test
    public void testGetResumo() {
        System.out.println("getResumo");
        Artigo instance = new Artigo();
        String expResult = "Teste resumo";
        instance.setTextoJustificativo(expResult);        
        String result = instance.getResumo();
        assertEquals(expResult, result);
    }


    /**
     * Test of setTipo method, of class Artigo.
     * Testa o set do tipo de artigo.
     */
    @Test
    public void testSetTipo() {
        System.out.println("setTipo");
        String tipo = "Full paper";
        Artigo instance = new Artigo();
        instance.setTipo(tipo);
        String expResult = "Full paper";
        String result = instance.getTipo();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAutor method, of class Artigo.
     */
    @Test
    public void testGetAutor() {
        System.out.println("getAutor");
        String id = "";
        Artigo instance = new Artigo();
        Autor expResult = null;
        Autor result = instance.getAutor(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getM_strFicheiro method, of class Artigo.
     */
    @Test
    public void testGetM_strFicheiro() {
        System.out.println("getM_strFicheiro");
        Artigo instance = new Artigo();
        String expResult = "";
        String result = instance.getM_strFicheiro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getM_listaTopicos method, of class Artigo.
     */
    @Test
    public void testGetM_listaTopicos() {
        System.out.println("getM_listaTopicos");
        Artigo instance = new Artigo();
        instance.setListaTopicos(topicos);
        List<Topico> expResult = topicos;
        List<Topico> result = instance.getM_listaTopicos();
        assertEquals(expResult, result);
    }

}
