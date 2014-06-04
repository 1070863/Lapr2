package eventoscientificos;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Classe de testes à classe CP
 *
 * @author Grupo66 LAPR2
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

    /**
     * Teste do método validaMembroCP(Passa no teste).
     */
    @Test
    public void testValidaMembroCP() {
        System.out.println("PassarTeste-validaMembroCP");
        Utilizador u1 = new Utilizador("jmrs", "", "Joel", "jmrs@nasa.com");
        Revisor r = new Revisor(u1);
        CP instance = new CP();
        instance.m_listaRevisores.add(r);
        boolean expResult = true;
        boolean result = instance.validaMembroCP(r);
        assertEquals(expResult, result);
    }

}
