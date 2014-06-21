package eventoscientificos;

/**
 * Interface pagamento calcula o valor a pagar pelo registo num evento
 * científico de acordo com a fórmual definida.
 *
 * @author GRUPO66 LAPR2
 */
public interface FormulaCalculo {

    /**
     * Método de cálculo de valor a pagar pelo registo no evento.
     *
     * @param numFP numero de Full Papers
     * @param numPP numero de Poster Papers
     * @param numSP numero de Short Papers
     * @return valor a pagar
     */
    public abstract double calculaValor(int numFP, int numPP, int numSP);
}
