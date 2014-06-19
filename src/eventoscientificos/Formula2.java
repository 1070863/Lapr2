package eventoscientificos;

/**
 * Classe que cálcula o pagamento a efetuar pelo autor de um artigo quando o
 * mesmo pretende efetuar o registo no Evento.
 *
 * @author GRUPO66 LAPR2
 */
public class Formula2 implements Pagamento {

    Evento m_evento;

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
        return numFP * this.m_evento.getM_registoNoEvento().getPriceFP()
                + this.m_evento.getM_registoNoEvento().getPriceSP() * (numSP - (numFP / 2))
                + this.m_evento.getM_registoNoEvento().getPricePP() * (numPP - (numFP / 2));
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
                + this.m_evento.getM_registoNoEvento().getPricePP() * (numPP - (numFP / 2));
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
                    + this.m_evento.getM_registoNoEvento().getPriceSP() * (numSP - (numFP / 2));
    }
}
