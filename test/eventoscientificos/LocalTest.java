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
 * @author Toshiba
 */
public class LocalTest {

    public LocalTest() {
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
     * Test of toString method, of class Local.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Local instance = new Local();
        instance.setM_strCidade("Porto");
        instance.setM_strLocal("ISEP");
        instance.setM_strPais("Portugal");
        String expResult = "Local: ISEP\nCidade: Porto\nPaís: Portugal";
        String result = instance.toString();
        assertEquals(expResult, result);

    }

    /**
     * Test of equals method, of class Local.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new Local("ISEP", "Lisboa", "Portugal");
        Local instance = new Local();

        instance.setM_strCidade("Porto");
        instance.setM_strLocal("ISEP");
        instance.setM_strPais("Portugal");

        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

}
