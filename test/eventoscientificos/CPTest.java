/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eventoscientificos;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Toshiba
 */
public class CPTest {
    
    public CPTest() {
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
//
//    /**
//     * Test of addMembroCP method, of class CP.
//     */
//    @Test
//    public void testAddMembroCP() {
//        System.out.println("addMembroCP");
//        String strId = "";
//        Utilizador u = null;
//        CP instance = new CP();
//        Revisor expResult = null;
//        Revisor result = instance.addMembroCP(strId, u);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of validaEmailMembroCP method, of class CP.
     */
    @Test
    public void testValidaMembroCP() {
        System.out.println("validaMembroCP");
        Utilizador u = new Utilizador();
        u.setM_strEmail("coisas@teste");
        u.setM_strUsername("user");
        Utilizador u1 = new Utilizador();
        u1.setM_strEmail("coisas777@teste");
        u1.setM_strUsername("user777");
        Revisor r = new Revisor(u);
        
        Revisor r1 = new Revisor(u1);
        
        
        CP cp = new CP();
        cp.m_listaRevisores.add(r1);
        
        boolean expResult = false;
        boolean result = cp.validaMembroCP(r);
        assertEquals(expResult, result);
        
        
    }
//
//    /**
//     * Test of registaMembroCP method, of class CP.
//     */
//    @Test
//    public void testRegistaMembroCP() {
//        System.out.println("registaMembroCP");
//        Revisor r = null;
//        CP instance = new CP();
//        boolean expResult = false;
//        boolean result = instance.registaMembroCP(r);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of toString method, of class CP.
//     */
//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        CP instance = new CP();
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getListaRevisores method, of class CP.
//     */
//    @Test
//    public void testGetListaRevisores() {
//        System.out.println("getListaRevisores");
//        CP instance = new CP();
//        List<Revisor> expResult = null;
//        List<Revisor> result = instance.getListaRevisores();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
