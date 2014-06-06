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
public class UtilizadorTest {
    
    public UtilizadorTest() {
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
     * Test of setNome method, of class Utilizador.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String strNome = "Buck Rogers";
        Utilizador instance = new Utilizador();
        instance.setM_strNome(strNome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsername method, of class Utilizador.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String strUsername = "";
        Utilizador instance = new Utilizador();
        instance.setM_strUsername(strUsername);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class Utilizador.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String strPassword = "";
        Utilizador instance = new Utilizador();
        instance.setM_strPassword(strPassword);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class Utilizador.
     * 
     * Devem ser feitas as validaEmailções de negócio aquando do registo de alterações dos dados
 email tem de ser sempre em minúsculas, não acentuado, sem espaços no meio e conter @
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String strEmail = " BucKR@NASA.gov ";
        Utilizador instance = new Utilizador();
        instance.setM_strEmail(strEmail);
        String expResult = " BucKR@NASA.gov ";
        String result = instance.getM_strEmail();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of validaEmail method, of class Utilizador.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        Utilizador instance = new Utilizador();
        String strEmail = "buckr@nasa.gov";
        instance.setM_strEmail(strEmail);
        boolean expResult = true;
        boolean result = instance.validaEmail();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of validaEmail method, of class Utilizador.
     */
    @Test
    public void testValidaNot() {
        System.out.println("valida - false");
        Utilizador instance = new Utilizador();
        String strEmail = " BucKR@NASA.gov ";
        instance.setM_strEmail(strEmail);
        boolean expResult = false;
        boolean result = instance.validaEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of mesmoQueUtilizador method, of class Utilizador.
     */
    @Test
    public void testMesmoQueUtilizador() {
        System.out.println("mesmoQueUtilizador");
        Utilizador u = null;
        Utilizador instance = new Utilizador();
        boolean expResult = false;
        boolean result = instance.equals(u);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNome method, of class Utilizador.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Utilizador instance = new Utilizador("buckr", "xyz", "Buck Rogers", "buckr@nasa.gov");
        String expResult = "Buck Rogers";
        String result = instance.getM_strNome();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsername method, of class Utilizador.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Utilizador instance = new Utilizador();
        String expResult = "";
        String result = instance.getM_strUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class Utilizador.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Utilizador instance = new Utilizador();
        String expResult = "";
        String result = instance.getM_strEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Utilizador.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Utilizador instance = new Utilizador();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Utilizador.
     */
    @Test
    public void testEquals() {
        System.out.println("equals - same username");
        Object obj = new Utilizador("buckr","", "Buck Rogers", "buckr@gmail.com");;
        Utilizador instance = new Utilizador("buckr","1234", "Buck Rogers", "buckr@nasa.gov");
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class Utilizador.
     */
    @Test
    public void testEqualsSameEmail() {
        System.out.println("equals - same email");
        Object obj = new Utilizador("bucky","", "Buck", "buckr@nasa.gov");;
        Utilizador instance = new Utilizador("buckr","1234", "Buck Rogers", "buckr@nasa.gov");
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class Utilizador.
     */
    @Test
    public void testEqualsNot() {
        System.out.println("equals not");
        Object obj = new Utilizador("bucky","", "Buck Rogers", "buckr@gmail.com");;
        Utilizador instance = new Utilizador("buckr","1234", "Buck Rogers", "buckr@nasa.gov");
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
}
