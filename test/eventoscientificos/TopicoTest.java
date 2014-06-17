package eventoscientificos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Classe de teste à classe Topico.
 *
 * @author Grupo&& LAPR2
 */
public class TopicoTest {

    private Topico topico;

    public TopicoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.topico = new Topico("descTESTE", "codTESTE");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setDescricao method, of class Topico.
     */
    @Test
    public void testSetDescricao() {
        System.out.println("setDescricao");
        String strDescricao = "NovaDescr";
        Topico instance = new Topico();
        instance.setDescricao(strDescricao);
        String expResult = strDescricao;
        String result = instance.getM_strDescricao();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCodigoACM method, of class Topico.
     */
    @Test
    public void testSetCodigoACM() {
        System.out.println("setCodigoACM");
        String codigoACM = "B.1.6";
        Topico instance = new Topico();
        instance.setCodigoACM(codigoACM);
        String expResult = codigoACM;
        String result = instance.getM_strCodigoACM();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Topico.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "\nCodigo: codTESTE\nDescrição: descTESTE";
        String result = this.topico.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getM_strDescricao method, of class Topico.
     */
    @Test
    public void testGetM_strDescricao() {
        System.out.println("getM_strDescricao");
        String expResult = "descTESTE";
        String result = this.topico.getM_strDescricao();
        assertEquals(expResult, result);
    }

    /**
     * Test of getM_strCodigoACM method, of class Topico.
     */
    @Test
    public void testGetM_strCodigoACM() {
        System.out.println("getM_strCodigoACM");
        Topico instance = new Topico();
        String expResult = "codTESTE";
        String result = this.topico.getM_strCodigoACM();
        assertEquals(expResult, result);

    }

    /**
     * Test of equals method, of class Topico.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Topico instance = new Topico();
        boolean expResult = false;
        boolean result = this.topico.equals(obj);
        assertEquals(expResult, result);
    }

}
