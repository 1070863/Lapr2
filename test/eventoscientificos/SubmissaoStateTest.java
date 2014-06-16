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
public class SubmissaoStateTest {

    public SubmissaoStateTest() {
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
     * Test of SetCriada method, of class SubmissaoState.
     */
    @Test
    public void testSetCriada() {
        System.out.println("SetCriada");
        SubmissaoState instance = new SubmissaoStateImpl();
        boolean expResult = false;
        boolean result = instance.SetCriada();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of SetArtigosParaRevisaoSubmetidos method, of class SubmissaoState.
     */
    @Test
    public void testSetArtigosParaRevisaoSubmetidos() {
        System.out.println("SetArtigosParaRevisaoSubmetidos");
        SubmissaoState instance = new SubmissaoStateImpl();
        boolean expResult = false;
        boolean result = instance.SetArtigosParaRevisaoSubmetidos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDestribuida method, of class SubmissaoState.
     */
    @Test
    public void testSetDestribuida() {
        System.out.println("setDestribuida");
        SubmissaoState instance = new SubmissaoStateImpl();
        boolean expResult = false;
        boolean result = instance.setDestribuida();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setRevista method, of class SubmissaoState.
     */
    @Test
    public void testSetRevista() {
        System.out.println("setRevista");
        SubmissaoState instance = new SubmissaoStateImpl();
        boolean expResult = false;
        boolean result = instance.setRevista();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setRejeitada method, of class SubmissaoState.
     */
    @Test
    public void testSetRejeitada() {
        System.out.println("setRejeitada");
        SubmissaoState instance = new SubmissaoStateImpl();
        boolean expResult = false;
        boolean result = instance.setRejeitada();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        ///fail("The test case is a prototype.");
    }

    /**
     * Test of setAceite method, of class SubmissaoState.
     */
    @Test
    public void testSetAceite() {
        System.out.println("setAceite");
        SubmissaoState instance = new SubmissaoStateImpl();
        boolean expResult = false;
        boolean result = instance.setAceite();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNotificadoAceite method, of class SubmissaoState.
     */
    @Test
    public void testSetNotificadoAceite() {
        System.out.println("setNotificadoAceite");
        SubmissaoState instance = new SubmissaoStateImpl();
        boolean expResult = false;
        boolean result = instance.setNotificadoAceite();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    public class SubmissaoStateImpl implements SubmissaoState {

        public boolean SetCriada() {
            return false;
        }

        public boolean SetArtigosParaRevisaoSubmetidos() {
            return false;
        }

        public boolean setDestribuida() {
            return false;
        }

        public boolean setRevista() {
            return false;
        }

        public boolean setRejeitada() {
            return false;
        }

        public boolean setAceite() {
            return false;
        }

        public boolean setNotificadoAceite() {
            return false;
        }

        @Override
        public boolean valida() {
            return true;
        }
    }

}
