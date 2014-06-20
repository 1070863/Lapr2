package eventoscientificos;

import java.io.Serializable;

/**
 * Classe responsável por definir os valores de pagamento do registo no evento.
 *
 * @author GRUPO66 LAPR2
 */
public class ValorRegistoNoEvento implements Serializable{
    private static final long serialVersionUID = 1L;

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
     * @param m_evento objeto do tipo Evento
     */
    public void setPagamentoRegFormual1(Evento m_evento) {
        this.pagamentoReg = new Formula1(m_evento);
    }

    /**
     * Define a fórmula1 como a formula de pagamento a ser usada.
     *
     * @param m_evento objeto do tipo Evento
     */
    public void setPagamentoRegFormual2(Evento m_evento) {
        this.pagamentoReg = new Formula2(m_evento);
    }

    /**
     * Reescrita do método toString da classe Object devolvendo informação
     * relativa à classe.
     *
     * @return infromação dos preços dos artigos e da fórmula aplicada
     */
    @Override
    public String toString() {
        return "Valores de Registo no Evento:\n"
                + "\n Preço Full Paper: " + getPriceFP()
                + "\n Preço Short Paper: " + getPriceSP()
                + "\n Preço Poster Paper: " + getPricePP()
                + "\n Fórmula de Cálculo: " + getPagamentoReg().getClass().getSimpleName();
    }

    /**
     * Reescrita do método equals para a classe ValorRegistoNoEvento.
     *
     * @param obj objeto do tipo ValorRegistoNoEvento
     * @return verdadeiro se igual e falso no caso contrário
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj instanceof ValorRegistoNoEvento) {
            ValorRegistoNoEvento aux = (ValorRegistoNoEvento) obj;
            if (this.priceFP == aux.getPriceFP() && this.pricePP == aux.getPricePP()
                    && this.priceSP == aux.getPriceSP()) {
                return true;
            }
        }
        return false;
    }
}
