package eventoscientificos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Classe de teste à interface FormulaCalculo.
 *
 * @author GRUPO66 LAPR2
 */
public class FormulaCalculoTeste {

    Evento m_evento;

    public FormulaCalculoTeste() {
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
        this.m_evento.getM_registoNoEvento().setPriceFP(2);
        this.m_evento.getM_registoNoEvento().setPriceSP(2);
        this.m_evento.getM_registoNoEvento().setPricePP(2);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of calculaValor method, of class FormulaCalculo.
     */
    @Test
    public void testCalculaValor() {
        System.out.println("calculaValor");
        int numFP = 2;
        int numPP = 4;
        int numSP = 5;
        FormulaCalculo instance = new PagamentoImpl();
        double expResult = 22.0;
        double result = instance.calculaValor(numFP, numPP, numSP);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Instância de classe pra teste da interface.
     */
    public class PagamentoImpl implements FormulaCalculo {

        /**
         * Calculo do valor a pagar usando a fórmula 1.
         *
         * @param numFP numero de Full Papers
         * @param numPP numero de Poster Papers
         * @param numSP numero de Short Papers
         * @return
         */
        public double calculaValor(int numFP, int numPP, int numSP) {
            double total = numFP * m_evento.getM_registoNoEvento().getPriceFP()
                    + numSP * m_evento.getM_registoNoEvento().getPriceSP()
                    + numPP * m_evento.getM_registoNoEvento().getPricePP();
            return total;
        }
    }

}
