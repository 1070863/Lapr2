/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eventoscientificos;

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
public class AutorTest {
    
    public AutorTest() {
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
     * Test of setNome method, of class Autor.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String strNome = "";
        Autor instance = new Autor();
        instance.setNome(strNome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAfiliacao method, of class Autor.
     */
    @Test
    public void testSetAfiliacao() {
        System.out.println("setAfiliacao");
        String strAfiliacao = "";
        Autor instance = new Autor();
        instance.setAfiliacao(strAfiliacao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEMail method, of class Autor.
     */
    @Test
    public void testSetEMail() {
        System.out.println("setEMail");
        String strEMail = "";
        Autor instance = new Autor();
        instance.setEMail(strEMail);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUtilizador method, of class Autor.
     */
    @Test
    public void testSetUtilizador() {
        System.out.println("setUtilizador");
        Utilizador utilizador = null;
        Autor instance = new Autor();
        instance.setUtilizador(utilizador);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valida method, of class Autor.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        Autor instance = new Autor();
        boolean expResult = false;
        boolean result = instance.valida();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of podeSerCorrespondente method, of class Autor.
     */
    @Test
    public void testPodeSerCorrespondente() {
        System.out.println("podeSerCorrespondente");
        Autor instance = new Autor();
        boolean expResult = false;
        boolean result = instance.podeSerCorrespondente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Autor.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Autor instance = new Autor();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Autor.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Autor instance = new Autor();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Autor.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Autor instance = new Autor();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
