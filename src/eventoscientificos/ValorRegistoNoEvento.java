package eventoscientificos;

/**
 * Classe responsável por definir os valores de pagamento do registo no evento.
 *
 * @author GRUPO66 LAPR2
 */
public class ValorRegistoNoEvento {

    /**
     * Variáveis de instância.
     */
    private double priceFP;
    private double pricePP;
    private double priceSP;

    private Pagamento pagamentoReg;

    /**
     * Construtor completo iniciado quando todos os atributos são passados como
     * parâmetros.
     *
     * @param priceFP preço de um Full Paper
     * @param pricePP preço de um Poster paper
     * @param priceSP preço de um Short Paper
     * @param pagamentoReg fórmula a ser usada no pagamento do registo
     */
    public ValorRegistoNoEvento(double priceFP, double pricePP, double priceSP, Pagamento pagamentoReg) {
        this.priceFP = priceFP;
        this.pricePP = pricePP;
        this.priceSP = priceSP;
    }

    /**
     * Construtor iniciado por omissão de parâmetros.
     */
    public ValorRegistoNoEvento() {
        this.priceFP = 0;
        this.pricePP = 0;
        this.priceSP = 0;
    }

    /**
     * Procura o preço de publicar um Full Paper.
     *
     * @return preço de um Full Paper
     */
    public double getPriceFP() {
        return priceFP;
    }

    /**
     * Define o preço da publicação de um Full Paper
     *
     * @param priceFP preço do Full Paper
     */
    public void setPriceFP(double priceFP) {
        this.priceFP = priceFP;
    }

    /**
     * Procura o preço de publicar um Poster Paper.
     *
     * @return preço de um Poster Paper
     */
    public double getPricePP() {
        return pricePP;
    }

    /**
     * Define o preço da publicação de um Poster Paper
     *
     * @param pricePP preço do Poster Paper
     */
    public void setPricePP(double pricePP) {
        this.pricePP = pricePP;
    }

    /**
     * Procura o preço de publicar um Short Paper.
     *
     * @return preço de um Short Paper
     */
    public double getPriceSP() {
        return priceSP;
    }

    /**
     * Define o preço da publicação de um Short Paper
     *
     * @param priceSP preço do Short Paper
     */
    public void setPriceSP(double priceSP) {
        this.priceSP = priceSP;
    }

    /**
     * Procura a fórmula de pagamento a ser usada.
     *
     * @return fórmula de pagamento
     */
    public Pagamento getPagamentoReg() {
        return pagamentoReg;
    }

    /**
     * Define a fórmula1 como a formula de pagamento a ser usada.
     *
     */
    public void setPagamentoRegFormual1() {
        this.pagamentoReg = new Formula1();
    }

    /**
     * Define a fórmula1 como a formula de pagamento a ser usada.
     *
     */
    public void setPagamentoRegFormual2() {
        this.pagamentoReg = new Formula2();
    }

}
