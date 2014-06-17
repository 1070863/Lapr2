package eventoscientificos;

/**
 * Classe que cria e gere a informação de tópicos, de acordo com a classificação
 * ACM e contendo um código e uma descrição.
 *
 * @author GRUPO66 LAPR2
 */
public class Topico {

    /**
     * Variáveis de instância.
     */
    private String m_strDescricao;
    private String m_strCodigoACM;

    /**
     * Construtor completo de topico quando todos os atributos são passados por
     * parâmetros.
     *
     * @param m_strDescricao descrição do tópico
     * @param m_strCodigoACM código do tópico
     */
    public Topico(String m_strDescricao, String m_strCodigoACM) {
        this.m_strDescricao = m_strDescricao;
        this.m_strCodigoACM = m_strCodigoACM;
    }

    /**
     * Construtor por omissão de parâmetros.
     */
    public Topico() {
        this.m_strDescricao = null;
        this.m_strCodigoACM = null;
    }

    /**
     * Define a descrição do tópico.
     *
     * @param strDescricao descrição do tópico
     */
    public void setDescricao(String strDescricao) {
        this.m_strDescricao = strDescricao;
    }

    /**
     * Define o código do tópico.
     *
     * @param codigoACM código do tópico
     */
    public void setCodigoACM(String codigoACM) {
        this.m_strCodigoACM = codigoACM;
    }

    public String getM_strDescricao() {
        return m_strDescricao;
    }

    public String getM_strCodigoACM() {
        return m_strCodigoACM;
    }

    /**
     * Reescrita do método toString, da classe Object, contendo informação do
     * Tópico ACM.
     *
     * @return informação do tópico em formato texto
     */
    @Override
    public String toString() {
        return "\nCodigo: " + this.m_strCodigoACM + "\nDescrição: " + this.m_strDescricao;
    }

    /**
     * Reescrita do método equals, da classe Object, comparando dois objetos e
     * verificando se são iguais.
     *
     * @param obj objeto a verificar
     * @return verdadeiro se o objeto for igual e falso no caso contrário
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj instanceof Topico) {
            Topico aux = (Topico) obj;
            return this.m_strCodigoACM.equals(aux.m_strCodigoACM);
        } else {
            return false;
        }
    }
}
