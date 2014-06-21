package eventoscientificos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Esta classe define e gere os valores a pagar para efetuar um registo num
 * determinado evento.
 *
 * @author GRUPO66 LAPR2
 */
public class ValorRegistoNoEventoTest {

    private Evento m_evento;
    private ValorRegistoNoEvento m_valorRegisto;

    public ValorRegistoNoEventoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.m_evento = new Evento();
        this.m_evento.definirValorRegisto();

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getPriceFP method, of class ValorRegistoNoEvento. Nota: Testado o
     * get e o set neste teste.
     */
    @Test
    public void testGetPriceFP() {
        System.out.println("getPriceFP");
        this.m_evento.getM_registoNoEvento().setPriceFP(2.58);
        double expResult = 2.58;
        double result = this.m_evento.getM_registoNoEvento().getPriceFP();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getPricePP method, of class ValorRegistoNoEvento. Nota: Testado o
     * get e o set neste teste.
     */
    @Test
    public void testGetPricePP() {
        System.out.println("getPricePP");
        this.m_evento.getM_registoNoEvento().setPricePP(2.58);
        double expResult = 2.58;
        double result = this.m_evento.getM_registoNoEvento().getPricePP();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getPriceSP method, of class ValorRegistoNoEvento.Nota: Testado o
     * get e o set neste teste.
     */
    @Test
    public void testGetPriceSP() {
        System.out.println("getPriceSP");
        this.m_evento.getM_registoNoEvento().setPriceSP(6.58);
        double expResult = 6.58;
        double result = this.m_evento.getM_registoNoEvento().getPriceSP();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setFormulaCalculoRegFormual1 method, of class ValorRegistoNoEvento.
     */
    @Test
    public void testSetPagamentoRegFormual1() {
        System.out.println("setPagamentoRegFormual1");
        this.m_evento.getM_registoNoEvento().setPagamentoRegFormual1(this.m_evento);
        this.m_evento.getM_registoNoEvento().setPriceFP(3);
        this.m_evento.getM_registoNoEvento().setPriceSP(3);
        this.m_evento.getM_registoNoEvento().setPricePP(3);
        double expResult = 18;
        double result = this.m_evento.getM_registoNoEvento().getPagamentoReg().calculaValor(3, 0, 3);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setFormulaCalculoRegFormual2 method, of class ValorRegistoNoEvento.
     */
    @Test
    public void testSetPagamentoRegFormual2() {
        System.out.println("setPagamentoRegFormual2");
        this.m_evento.getM_registoNoEvento().setPagamentoRegFormual2(this.m_evento);
        this.m_evento.getM_registoNoEvento().setPriceFP(3);
        this.m_evento.getM_registoNoEvento().setPriceSP(3);
        this.m_evento.getM_registoNoEvento().setPricePP(3);
        double expResult = 13.5;
        double result = this.m_evento.getM_registoNoEvento().getPagamentoReg().calculaValor(3, 0, 3);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of toString method, of class ValorRegistoNoEvento.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        this.m_evento.getM_registoNoEvento().setPagamentoRegFormual2(this.m_evento);
        this.m_evento.getM_registoNoEvento().setPriceFP(3.2);
        this.m_evento.getM_registoNoEvento().setPriceSP(3.2);
        this.m_evento.getM_registoNoEvento().setPricePP(3.2);
        String expResult = "Valores de Registo no Evento:\n"
                + "\n Preço Full Paper: 3.2" 
                + "\n Preço Short Paper: 3.2" 
                + "\n Preço Poster Paper: 3.2" 
                + "\n Fórmula de Cálculo: Formula2";
        String result = this.m_evento.getM_registoNoEvento().toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class ValorRegistoNoEvento.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Evento e1 = new Evento();
        e1.definirValorRegisto();
        e1.definirValorRegisto().setPagamentoRegFormual1(e1);
        e1.getM_registoNoEvento().setPriceFP(2);
        e1.getM_registoNoEvento().setPriceSP(2);
        e1.getM_registoNoEvento().setPricePP(2);
        Object obj = e1.getM_registoNoEvento();
        this.m_evento.definirValorRegisto();
        this.m_evento.getM_registoNoEvento().setPagamentoRegFormual1(this.m_evento);
        this.m_evento.getM_registoNoEvento().setPriceFP(2);
        this.m_evento.getM_registoNoEvento().setPriceSP(2);
        this.m_evento.getM_registoNoEvento().setPricePP(2);
        ValorRegistoNoEvento instance = this.m_evento.getM_registoNoEvento();
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
}
