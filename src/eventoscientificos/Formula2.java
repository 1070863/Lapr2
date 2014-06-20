package eventoscientificos;

import java.io.Serializable;

/**
 * Classe que cálcula o pagamento a efetuar pelo autor de um artigo quando o
 * mesmo pretende efetuar o registo no Evento.
 *
 * @author GRUPO66 LAPR2
 */
public class Formula2 implements Pagamento, Serializable {
    private static final long serialVersionUID = 1L;
    
    Evento m_evento;

    /**
     * Construtor completo quando é passado por atributo o objeto EVento.
     *
     * @param m_evento evento a implementar a formula 2
     */
    Formula2(Evento m_evento) {
        this.m_evento = m_evento;
    }

    /**
     * Reescrita do método abstrato calculaValor da interface Pagamento.
     *
     * @param numFP numero de Full Pappers a pagar
     * @param numPP numero de Poster Papers a pagar
     * @param numSP numero de Short Papers a pagar
     * @return valor total a pagar
     */
    @Override
    public double calculaValor(int numFP, int numPP, int numSP) {
        if (numSP > 0 && numPP > 0) {
            return condicao1(numFP, numPP, numSP);
        } else if (numSP == 0 && numPP > 0) {
            return condicao2(numFP, numPP);
        } else if (numSP > 0 && numPP == 0) {
            return calculo3(numFP, numSP);
        }
        return 0;
    }

    /**
     * Fórmula a aplicar no caso de no pagamento a ser efetuado constar pelo
     * menos um Short Paper e um Poster Paper.
     *
     * @param numFP numero de Full Pappers a pagar
     * @param numPP numero de Poster Papers a pagar
     * @param numSP numero de Short Papers a pagar
     * @return valor total a pagar
     */
    private double condicao1(int numFP, int numPP, int numSP) {
        double total1 = numFP * this.m_evento.getM_registoNoEvento().getPriceFP();
        double total2 = this.m_evento.getM_registoNoEvento().getPriceSP() * ((double) numSP - ((double) numFP / 2));
        double total3 = this.m_evento.getM_registoNoEvento().getPricePP() * ((double) numPP - ((double) numFP / 2));
        return total1 + total2 + total3;
    }

    /**
     * Fórmula a aplicar no caso de no pagamento a ser efetuado constar pelo
     * menos um Poster Paper e nenhum Short Paper.
     *
     * @param numFP numero de Full Pappers a pagar
     * @param numPP numero de Poster Papers a pagar
     * @param numSP numero de Short Papers a pagar
     * @return valor total a pagar
     */
    private double condicao2(int numFP, int numPP) {
        return this.m_evento.getM_registoNoEvento().getPriceFP() * numFP
                + this.m_evento.getM_registoNoEvento().getPricePP() * ((double) numPP - ((double) numFP / 2));
    }

    /**
     * Fórmula a aplicar no caso de no pagamento a ser efetuado constar pelo
     * menos um Short Paper e nenhum Poster Paper.
     *
     * @param numFP numero de Full Pappers a pagar
     * @param numPP numero de Poster Papers a pagar
     * @param numSP numero de Short Papers a pagar
     * @return valor total a pagar
     */
    private double calculo3(int numFP, int numSP) {
        return this.m_evento.getM_registoNoEvento().getPriceFP() * numFP
                + this.m_evento.getM_registoNoEvento().getPriceSP() * ((double) numSP - ((double) numFP / 2));
    }
}
