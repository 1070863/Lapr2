package eventoscientificos;

import java.io.Serializable;

/**
 * Classe que cálcula o pagamento a efetuar pelo autor de um artigo quando o
 * mesmo pretende efetuar o registo no Evento.
 *
 * @author GRUPO66 LAPR2
 */
public class Formula1 implements FormulaCalculo, Serializable {

    private static final long serialVersionUID = 1L;

    private ValorRegistoNoEvento m_valor;

    public Formula1(ValorRegistoNoEvento m_valor) {
        this.m_valor = m_valor;
    }

    /**
     * Reescrita do método abstrato calculaValor da interface FormulaCalculo.
     *
     * @param numFP numero de Full Pappers a pagar
     * @param numPP numero de Poster Papers a pagar
     * @param numSP numero de Short Papers a pagar
     * @return valor total a pagar
     */
    @Override
    public double calculaValor(int numFP, int numPP, int numSP) {
        double total = 0;
        total += numFP * this.m_valor.getPriceFP()
                + numSP * this.m_valor.getPriceSP()
                + numPP * this.m_valor.getPricePP();
        return total;
    }
}
