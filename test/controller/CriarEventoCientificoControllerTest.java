/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import eventoscientificos.Empresa;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lopes
 */
public class CriarEventoCientificoControllerTest {
    
    private static Empresa empresa;
    
    public CriarEventoCientificoControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        empresa = new Empresa();
        
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
//
//    /**
//     * Test of novoEvento method, of class CriarEventoCientificoController.
//     */
//    @Test
//    public void testNovoEvento() {
//        System.out.println("novoEvento");
//        CriarEventoCientificoController instance = null;
//        instance.novoEvento();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getEventoString method, of class CriarEventoCientificoController.
//     */
//    @Test
//    public void testGetEventoString() {
//        System.out.println("getEventoString");
//        CriarEventoCientificoController instance = null;
//        String expResult = "";
//        String result = instance.getEventoString();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setTitulo method, of class CriarEventoCientificoController.
//     */
//    @Test
//    public void testSetTitulo() {
//        System.out.println("setTitulo");
//        String strTitulo = "";
//        CriarEventoCientificoController instance = null;
//        instance.setTitulo(strTitulo);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setDescricao method, of class CriarEventoCientificoController.
//     */
//    @Test
//    public void testSetDescricao() {
//        System.out.println("setDescricao");
//        String strDescricao = "";
//        CriarEventoCientificoController instance = null;
//        instance.setDescricao(strDescricao);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setLocal method, of class CriarEventoCientificoController.
//     */
//    @Test
//    public void testSetLocal() {
//        System.out.println("setLocal");
//        String strLocal = "";
//        CriarEventoCientificoController instance = null;
//        instance.setLocal(strLocal);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setDataInicio method, of class CriarEventoCientificoController.
//     */
//    @Test
//    public void testSetDataInicio() {
//        System.out.println("setDataInicio");
//        String strDataInicio = "";
//        CriarEventoCientificoController instance = null;
//        instance.setDataInicio(strDataInicio);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setDataFim method, of class CriarEventoCientificoController.
//     */
//    @Test
//    public void testSetDataFim() {
//        System.out.println("setDataFim");
//        String strDataFim = "";
//        CriarEventoCientificoController instance = null;
//        instance.setDataFim(strDataFim);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setDataLimiteSubmissão method, of class CriarEventoCientificoController.
//     */
//    @Test
//    public void testSetDataLimiteSubmissão() {
//        System.out.println("setDataLimiteSubmiss\u00e3o");
//        String strDataLimiteSubmissão = "";
//        CriarEventoCientificoController instance = null;
//        instance.setDataLimiteSubmissão(strDataLimiteSubmissão);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setDataLimiteRevisao method, of class CriarEventoCientificoController.
//     */
//    @Test
//    public void testSetDataLimiteRevisao() {
//        System.out.println("setDataLimiteRevisao");
//        String strDataLimiteRevisao = "";
//        CriarEventoCientificoController instance = null;
//        instance.setDataLimiteRevisao(strDataLimiteRevisao);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setDataLimiteRegisto method, of class CriarEventoCientificoController.
//     */
//    @Test
//    public void testSetDataLimiteRegisto() {
//        System.out.println("setDataLimiteRegisto");
//        String strDataLimiteRegisto = "";
//        CriarEventoCientificoController instance = null;
//        instance.setDataLimiteRegisto(strDataLimiteRegisto);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setNumeroMaximoTopicos method, of class CriarEventoCientificoController.
//     */
//    @Test
//    public void testSetNumeroMaximoTopicos() {
//        System.out.println("setNumeroMaximoTopicos");
//        int nMaxTopicos = 0;
//        CriarEventoCientificoController instance = null;
//        instance.setNumeroMaximoTopicos(nMaxTopicos);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setPrecoFull method, of class CriarEventoCientificoController.
//     */
//    @Test
//    public void testSetPrecoFull() {
//        System.out.println("setPrecoFull");
//        int precoFull = 0;
//        CriarEventoCientificoController instance = null;
//        instance.setPrecoFull(precoFull);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setPrecoShort method, of class CriarEventoCientificoController.
//     */
//    @Test
//    public void testSetPrecoShort() {
//        System.out.println("setPrecoShort");
//        int precoShort = 0;
//        CriarEventoCientificoController instance = null;
//        instance.setPrecoShort(precoShort);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setPrecoPoster method, of class CriarEventoCientificoController.
//     */
//    @Test
//    public void testSetPrecoPoster() {
//        System.out.println("setPrecoPoster");
//        int precoPoster = 0;
//        CriarEventoCientificoController instance = null;
//        instance.setPrecoPoster(precoPoster);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addOrganizador method, of class CriarEventoCientificoController.
//     */
//    @Test
//    public void testAddOrganizador() {
//        System.out.println("addOrganizador");
//        String strId = "";
//        CriarEventoCientificoController instance = null;
//        boolean expResult = false;
//        boolean result = instance.addOrganizador(strId);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of validaEvento method, of class CriarEventoCientificoController.
     */
    @Test
    public void testValidaEvento() {
        System.out.println("validaEvento");
        String ID = "Evento1";
        CriarEventoCientificoController instance = new CriarEventoCientificoController(empresa);
        instance.novoEvento();       
        instance.setTitulo(ID);
        instance.registaEvento();
        boolean expResult = true;
        boolean result = instance.validaEvento(ID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

//    /**
//     * Test of registaEvento method, of class CriarEventoCientificoController.
//     */
//    @Test
//    public void testRegistaEvento() {
//        System.out.println("registaEvento");
//        CriarEventoCientificoController instance = null;
//        boolean expResult = false;
//        boolean result = instance.registaEvento();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
