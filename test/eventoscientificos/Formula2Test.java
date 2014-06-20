package eventoscientificos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Classe de teste à classe Formula2 que implementa a interface Pagamento.
 *
 * @author GRUPO66 LAPR2
 */
public class Formula2Test {

    Evento m_evento;
    ValorRegistoNoEvento m_ValorRegistoNoEvento;

    public Formula2Test() {
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
        this.m_ValorRegistoNoEvento = this.m_evento.definirValorRegisto();
        this.m_ValorRegistoNoEvento.setPagamentoRegFormual2(this.m_evento);
        this.m_evento.getM_registoNoEvento().setPriceFP(5);
        this.m_evento.getM_registoNoEvento().setPriceSP(10);
        this.m_evento.getM_registoNoEvento().setPricePP(15);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of calculaValor method, of class Formula2.
     */
    @Test
    public void testCalculaValor() {
        System.out.println("calculaValor");
        int numFP = 3;
        int numPP = 2;
        int numSP = 1;

        double expResult = 17.5;
        double result = this.m_evento.getM_registoNoEvento().getPagamentoReg().calculaValor(numFP, numPP, numSP);
        assertEquals(expResult, result, 0.0);
    }

}
