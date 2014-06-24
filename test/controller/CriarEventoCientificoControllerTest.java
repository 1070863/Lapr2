package controller;

import eventoscientificos.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Classe de teste à classe CriarEventoCientificoController.
 *
 * @author GRUPO66 LAPR2
 */
public class CriarEventoCientificoControllerTest {
    
    private static CriarEventoCientificoController instance;
    private static Empresa empresa;
    
    public CriarEventoCientificoControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        empresa = new Empresa();
        instance = new CriarEventoCientificoController(empresa);
        
        String ID = "Evento1"; 
        instance.novoEvento();       
        instance.setTitulo(ID);
        
        Utilizador u = new Utilizador("teste", "teste", "teste", "teste@ttt.tt");
        empresa.getM_registaUtilizador().registaUtilizador(u);
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
     * Test of addOrganizador method, of class CriarEventoCientificoController.
     */
    @Test
    public void testAddOrganizador() {
        System.out.println("addOrganizador");
        String strId = "teste@ttt.tt";
        boolean expResult = true;
        boolean result = instance.addOrganizador(strId);
        assertEquals(expResult, result);
    }

    /**
     * Test of registaEvento method, of class CriarEventoCientificoController.
     */
    @Test
    public void testRegistaEvento() {
        System.out.println("registaEvento");
        instance.novoEvento();       
        instance.setTitulo( "Evento2");
        instance.setDescricao("descricao");
        instance.addOrganizador("teste@ttt.tt");
        boolean expResult = true; 
        boolean result = instance.registaEvento();
        assertEquals(expResult, result);
    }
    
        /**
     * Test of validaEvento method, of class CriarEventoCientificoController.
     */
    @Test
    public void testValidaEvento() {
        System.out.println("validaEvento");
        String ID = "Evento2";
        boolean expResult = true;
        boolean result = instance.validaEvento(ID);
        assertEquals(expResult, result);
    }
    
}
