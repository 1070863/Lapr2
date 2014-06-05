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
 * @author Pereira
 */
public class RegistoUtilizadorTest {
    
    public RegistoUtilizadorTest() {
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
     * Test of registaUtilizador method, of class RegistoUtilizador.
     */
    @Test
    public void testRegistaUtilizador() {
        System.out.println("registaUtilizador");
        Utilizador u = new Utilizador("123","1234","nome","mail@mail.com");
        RegistoUtilizador instance = new RegistoUtilizador();
        boolean expResult = true;
        boolean result = instance.registaUtilizador(u);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getUtilizador method, of class RegistoUtilizador.
     */
    @Test
    public void testGetUtilizador() {
        System.out.println("getUtilizador");
        String strId = "SEM USERNAME";
        RegistoUtilizador instance = new RegistoUtilizador();
        Utilizador expResult = instance.setUtilizador(strId);
        Utilizador result = instance.getUtilizador(strId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getUtilizadorEmail method, of class RegistoUtilizador.
     */
    @Test
    public void testGetUtilizadorEmail() {
        System.out.println("getUtilizadorEmail");
        String strEmail = "G66@mail.pt";
        RegistoUtilizador instance = new RegistoUtilizador();
        Utilizador expResult = instance.setUtilizadorEmail(strEmail);
        Utilizador result = instance.getUtilizadorEmail(strEmail);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addUtilizador method, of class RegistoUtilizador.
     */
    @Test
    public void testAddUtilizador() {
        System.out.println("addUtilizador");
        Utilizador u = new Utilizador();
        RegistoUtilizador instance = new RegistoUtilizador();
        boolean expResult = true;
        boolean result = instance.addUtilizador(u);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      // fail("The test case is a prototype.");
    }
    
}