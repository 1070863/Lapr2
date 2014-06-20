package eventoscientificos;

/**
 * Classe que cálcula o pagamento a efetuar pelo autor de um artigo quando o
 * mesmo pretende efetuar o registo no Evento.
 *
 * @author GRUPO66 LAPR2
 */
public class Formula1 implements Pagamento {

    private Evento m_evento;

    public Formula1(Evento m_evento) {
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
        double total = 0;
        total += numFP * this.m_evento.getM_registoNoEvento().getPriceFP()
                + numSP * this.m_evento.getM_registoNoEvento().getPriceSP()
                + numPP * this.m_evento.getM_registoNoEvento().getPricePP();
        return total;
    }
}
