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

    /**
     * Test of getTipo method, of class Artigo.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        Artigo instance = new Artigo();
        String expResult = "";
        String result = instance.getTipo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTitulo method, of class Artigo.
     */
    @Test
    public void testSetTitulo() {
        System.out.println("setTitulo");
        String strTitulo = "";
        Artigo instance = new Artigo();
        instance.setTitulo(strTitulo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setResumo method, of class Artigo.
     */
    @Test
    public void testSetResumo() {
        System.out.println("setResumo");
        String strResumo = "";
        Artigo instance = new Artigo();
        instance.setResumo(strResumo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of novoAutor method, of class Artigo.
     */
    @Test
    public void testNovoAutor_String_String() {
        System.out.println("novoAutor");
        String strNome = "";
        String strAfiliacao = "";
        Artigo instance = new Artigo();
        Autor expResult = null;
        Autor result = instance.novoAutor(strNome, strAfiliacao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of novoAutor method, of class Artigo.
     */
    @Test
    public void testNovoAutor_4args() {
        System.out.println("novoAutor");
        String strNome = "";
        String strAfiliacao = "";
        String strEmail = "";
        Utilizador utilizador = null;
        Artigo instance = new Artigo();
        Autor expResult = null;
        Autor result = instance.novoAutor(strNome, strAfiliacao, strEmail, utilizador);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addAutor method, of class Artigo.
     */
    @Test
    public void testAddAutor() {
        System.out.println("addAutor");
        Autor autor = null;
        Artigo instance = new Artigo();
        boolean expResult = false;
        boolean result = instance.addAutor(autor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPossiveisAutoresCorrespondentes method, of class Artigo.
     */
    @Test
    public void testGetPossiveisAutoresCorrespondentes() {
        System.out.println("getPossiveisAutoresCorrespondentes");
        Artigo instance = new Artigo();
        List<Autor> expResult = null;
        List<Autor> result = instance.getPossiveisAutoresCorrespondentes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAutorCorrespondente method, of class Artigo.
     */
    @Test
    public void testSetAutorCorrespondente() {
        System.out.println("setAutorCorrespondente");
        Autor autor = null;
        Artigo instance = new Artigo();
        instance.setAutorCorrespondente(autor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFicheiro method, of class Artigo.
     */
    @Test
    public void testSetFicheiro() {
        System.out.println("setFicheiro");
        String strFicheiro = "";
        Artigo instance = new Artigo();
        instance.setFicheiro(strFicheiro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaTopicos method, of class Artigo.
     */
    @Test
    public void testSetListaTopicos() {
        System.out.println("setListaTopicos");
        List<Topico> listaTopicos = null;
        Artigo instance = new Artigo();
        instance.setListaTopicos(listaTopicos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInfo method, of class Artigo.
     */
    @Test
    public void testGetInfo() {
        System.out.println("getInfo");
        Artigo instance = new Artigo();
        String expResult = "";
        String result = instance.getInfo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Artigo.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Artigo instance = new Artigo();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
