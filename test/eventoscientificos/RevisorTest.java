package eventoscientificos;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Classe de teste à classe Revisor.
 *
 * @author GRUPO66 LAPR2
 */
public class RevisorTest {

    private String m_strNome;
    private Utilizador m_utilizador;
    private List<Topico> m_listaTopicos;
    private Topico m_topico;
    private Revisor instance;

    public RevisorTest() {
        instance = new Revisor();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.m_utilizador = new Utilizador("João Vasco", "jv83", "", "jv@ccc.pt");
        this.m_strNome = this.m_utilizador.getM_strNome();
        this.m_listaTopicos = new ArrayList<>();
        this.m_topico = new Topico("cod", "descr");
        instance.setM_listaTopicos(m_listaTopicos);
        instance.setM_utilizador(this.m_utilizador);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getM_strNome method, of class Revisor.
     */
    @Test
    public void testGetM_strNome() {
        System.out.println("getM_strNome");
        String expResult = "João Vasco";
        String result = this.m_utilizador.getM_strNome();
        assertEquals(expResult, result);
    }

    /**
     * Test of setM_strNome method, of class Revisor.
     */
    @Test
    public void testSetM_strNome() {
        System.out.println("setM_strNome");
        String m_strNome = "Manuel Santos";
        this.m_utilizador.setM_strNome(m_strNome);
        String expResult = m_strNome;
        String result = this.m_utilizador.getM_strNome();
        assertEquals(expResult, result);
    }

    /**
     * Test of getM_utilizador method, of class Revisor.
     */
    @Test
    public void testGetM_utilizador() {
        System.out.println("getM_utilizador");
        instance.setM_utilizador(m_utilizador);
        Utilizador expResult = new Utilizador("João Vasco", "jv83", "", "jv@ccc.pt");
        Utilizador result = instance.getM_utilizador();
        assertEquals(expResult, result);
    }

    /**
     * Test of getM_listaTopicos method, of class Revisor.
     */
    @Test
    public void testGetM_listaTopicos() {
        System.out.println("getM_listaTopicos");
        instance.setM_listaTopicos(this.m_listaTopicos);
        List<Topico> expResult = this.m_listaTopicos;
        List<Topico> result = this.instance.getM_listaTopicos();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Revisor.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "João Vasco: ";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Revisor.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of getConfianca method, of class Revisor.
     */
    @Test
    public void testGetConfianca() {
        System.out.println("getConfianca");
        Revisor instance = new Revisor();
        String expResult = "0";
        instance.setConfianca(expResult);
        String result = instance.getConfianca();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAdequacao method, of class Revisor.
     */
    @Test
    public void testGetAdequacao() {
        System.out.println("getAdequacao");
        Revisor instance = new Revisor();
        String expResult = "1";
        instance.setAdequacao(expResult);
        String result = instance.getAdequacao();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOriginalidade method, of class Revisor.
     */
    @Test
    public void testGetOriginalidade() {
        System.out.println("getOriginalidade");
        Revisor instance = new Revisor();
        String expResult = "2";
        instance.setOriginalidade(expResult);
        String result = instance.getOriginalidade();
        assertEquals(expResult, result);
    }

    /**
     * Test of getQualidade method, of class Revisor.
     */
    @Test
    public void testGetQualidade() {
        System.out.println("getQualidade");
        Revisor instance = new Revisor();
        String expResult = "3";
        instance.setQualidade(expResult);
        String result = instance.getQualidade();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRecomendacao method, of class Revisor.
     */
    @Test
    public void testGetRecomendacao() {
        System.out.println("getRecomendacao");
        Revisor instance = new Revisor();
        boolean expResult = true;
        instance.setRecomendacao(expResult);
        boolean result = instance.getRecomendacao();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTextoJustificativo method, of class Revisor.
     */
    @Test
    public void testGetTextoJustificativo() {
        System.out.println("getTextoJustificativo");
        Revisor instance = new Revisor();
        String expResult = "Teste texto";
        instance.setTextoJustificativo(expResult);
        String result = instance.getTextoJustificativo();
        assertEquals(expResult, result);
    }

    /**
     * Test of setM_utilizador method, of class Revisor.
     */
    @Test
    public void testSetM_utilizador() {
        System.out.println("setM_utilizador");
        Utilizador m_utilizador = new Utilizador("Utilizador 1", "utilizador1", 
                "utilizador1", "utilizador@mail.pt");
        Revisor instance = new Revisor();
        instance.setM_utilizador(m_utilizador);
        Utilizador expResult = m_utilizador;
        Utilizador result = instance.getM_utilizador();
        assertEquals(expResult, result);
    }

   
}
