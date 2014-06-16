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
        Utilizador instance = new Utilizador(strNome,"1070863","1070863","1070863@isep.ipp.pt");
        instance.setM_strNome(strNome);
         String result=instance.getM_strNome();
         String expectResult= strNome;
         assertSame(expectResult, result);
    }

    /**
     * Test of setUsername method, of class Utilizador.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String strUsername = "1070863";
        Utilizador instance = new Utilizador("sergio",strUsername,"1070863","1070863@isep.ipp.pt");
        instance.setM_strNome(strUsername);
         String result=instance.getM_strUsername();
         String expectResult= strUsername;
         assertSame(expectResult, result);
    }

    /**
     * Test of setPassword method, of class Utilizador.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String strPassword = "1234";
        Utilizador instance = new Utilizador("sergio","1070863",strPassword,"1070863@isep.ipp.pt");
        instance.setM_strNome(strPassword);
         String result=instance.getM_strPassword();
         String expectResult= strPassword;
         assertSame(expectResult, result);
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
        String strEmail = " BUCKR@NASA.PT ";
        Utilizador instance = new Utilizador("sergio","1070863","1070863",strEmail);
        instance.setM_strNome(strEmail);
         String result=instance.getM_strEmail();
         String expectResult= strEmail;
         assertSame(expectResult, result);
    }
    
    /**
     * Test of validaEmail method, of class Utilizador.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        String strEmail = "buckr@nasa.gov";
        Utilizador instance = new Utilizador("sergio","1070863","1070863",strEmail);
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
     * Test of getNome method, of class Utilizador.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
         String strNome = "Buck Rogers";
        Utilizador instance = new Utilizador(strNome,"1070863","1070863","1070863@isep.ipp.pt");
        instance.setM_strNome(strNome);
         String result=instance.getM_strNome();
         String expectResult= strNome;
         assertEquals(expectResult, result);
    }

    /**
     * Test of getUsername method, of class Utilizador.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        String strUsername = "1070863";
        Utilizador instance = new Utilizador("sergio","1070863",strUsername,"1070863@isep.ipp.pt");
        instance.setM_strNome(strUsername);
         String result=instance.getM_strUsername();
         String expectResult= strUsername;
         assertSame(expectResult, result);
    }

    /**
     * Test of getEmail method, of class Utilizador.
     */
    @Test
    public void testGetEmail() {
         System.out.println("setEmail");
        String strEmail = " BUCKR@NASA.PT ";
        Utilizador instance = new Utilizador("sergio","1070863","1070863",strEmail);
        instance.setM_strNome(strEmail);
         String result=instance.getM_strEmail();
         String expectResult= strEmail;
         assertEquals(expectResult, result);
      

    }

    /**
     * Test of toString method, of class Utilizador.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String m_strNome ="Sergio"; 
        String m_strUsername= "1070863";
        String m_strPassword="gstere";
        String m_strEmail= "MAIL@MAIL.PT";
        String str = "Utilizador:\n";
        str += "\tNome: " + m_strNome + "\n";
        str += "\tUsername: " + m_strUsername + "\n";
        str += "\tPassword: " + m_strPassword + "\n";
        str += "\tEmail: " + m_strEmail + "\n";
        Utilizador instance = new Utilizador(m_strNome,m_strUsername,m_strPassword,m_strEmail);
        String expResult = str;
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of equals method, of class Utilizador.
     */
    @Test
    public void testEquals() {
        System.out.println("equals - same username");
        Utilizador obj = new Utilizador("buckr","1234", "Buck Rogers", "buckr@nasa.gov");
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
        Utilizador obj = new Utilizador("bucky","", "Buck", "buckr@nasa.gov");
        Utilizador instance = new Utilizador("bucky","", "Buck", "buckr@nasa.gov");
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
