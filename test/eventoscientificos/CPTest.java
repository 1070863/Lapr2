package eventoscientificos;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Classe de teste à classe CP(Comissão de Programa).
 *
 * @author GRUPO66 LAPR2
 */
public class CPTest {

    List<Revisor> m_listaRevisores;
    Revisor m_revisor;
    Utilizador m_utilizador;
    CP m_cp;

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
        this.m_utilizador = new Utilizador("nome", "user", "pass", "email@mail.com");
        this.m_revisor = new Revisor(this.m_utilizador);
        this.m_cp = new CP();

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addMembroCP method, of class CP.
     */
    @Test
    public void testAddMembroCP() {
        System.out.println("addMembroCP");
        String strId = "user";
        Revisor result = this.m_cp.addMembroCP(strId, this.m_utilizador);
        Revisor expResult = this.m_revisor;
        assertEquals(expResult, result);
    }

    /**
     * Test of validaEmailMembroCP method, of class CP.
     */
    @Test
    public void testValidaMembroCP() {
        System.out.println("validaMembroCP");
        boolean expResult = false;
        boolean result = this.m_cp.validaMembroCP(this.m_revisor);
        assertEquals(expResult, result);
    }

    /**
     * Test of registaMembroCP method, of class CP.
     */
    @Test
    public void testRegistaMembroCP() {
        System.out.println("registaMembroCP");
        boolean expResult = true;
        boolean result = this.m_cp.registaMembroCP(this.m_revisor);
        assertEquals(expResult, result);

    }

    /**
     * Test of toString method, of class CP.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        this.m_cp.getListaRevisores().add(this.m_revisor);
        String expResult = "Membros de CP: nome";
        String result = this.m_cp.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaRevisores method, of class CP.
     */
    @Test
    public void testGetListaRevisores() {
        System.out.println("getListaRevisores");
        this.m_cp.setM_listaRevisores(this.m_listaRevisores);
        List<Revisor> expResult = this.m_listaRevisores;
        List<Revisor> result = this.m_cp.getListaRevisores();
        assertEquals(expResult, result);
    }

}
