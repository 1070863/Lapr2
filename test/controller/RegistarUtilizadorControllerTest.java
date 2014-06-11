/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import eventoscientificos.Empresa;
import eventoscientificos.*;
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
public class RegistarUtilizadorControllerTest {
    
    public RegistarUtilizadorControllerTest() {
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
     * Test of setDados method, of class RegistarUtilizadorController.
     */
    @Test
    public void testSetDados() {
        System.out.println("setDados");
        Empresa m_empresa= new Empresa();
        String strNome = "sem_nome";
        String strPassword = "sem_pasword";
        String strUsername = "sem_user";
        String strEmail = "sem_email";
        RegistarUtilizadorController instance = new RegistarUtilizadorController(m_empresa);
        Utilizador expResult = new Utilizador();
        Utilizador result = instance.setDados(strNome, strPassword, strUsername, strEmail);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of ValidarUtilizador method, of class RegistarUtilizadorController.
     */
    @Test
    public void testValidarUtilizador() {
        System.out.println("ValidarUtilizador");
        Empresa m_empresa= new Empresa();
        Utilizador m_Utilizador = new Utilizador("123","1234","nome","mail@mail.com");
        RegistarUtilizadorController instance = new RegistarUtilizadorController(m_empresa);
        boolean expResult = true;
        boolean result = instance.ValidarUtilizador(instance.setDados("Sergio", "1070863", "1070863", "1070863@isep.ipp.pt"));
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getM_utilizador method, of class RegistarUtilizadorController.
     */
    @Test
    public void testGetM_utilizador() {
        System.out.println("getM_utilizador");
        
        Empresa m_empresa= new Empresa();
        Utilizador u= new Utilizador("Sergio", "1070863", "1070863", "1070863@isep.ipp.pt");
        RegistarUtilizadorController instance = new RegistarUtilizadorController(m_empresa);
        instance.setDados("Sergio", "1070863", "1070863", "1070863@isep.ipp.pt");
        Utilizador expResult = u;
        Utilizador result = instance.getM_utilizador();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
