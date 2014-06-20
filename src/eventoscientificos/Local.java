package eventoscientificos;

import java.io.Serializable;

/**
 * Esta classe cria um objeto do tipo Local com os atributos local,cidade e
 * país.
 *
 * @author Grupo66 LAPR2
 */
public class Local implements Serializable{
    private static final long serialVersionUID = 1L;
    
    /**
     * Atributos de instância.
     */
    private String m_strLocal;
    private String m_strCidade;
    private String m_strPais;

    /**
     * Construtor de instância Local quando todos os parêmetros são passados.
     *
     * @param m_strLocal local de realização
     * @param m_strCidade cidade onde se situa o local
     * @param m_strPais país onde se situa o local
     */
    public Local(String m_strLocal, String m_strCidade, String m_strPais) {
        this.m_strLocal = m_strLocal;
        this.m_strCidade = m_strCidade;
        this.m_strPais = m_strPais;
    }

    /**
     * Construtor por omissão de instância Local.
     */
    public Local() {
        this.m_strLocal = "sem_local";
        this.m_strCidade = "sem_cidade";
        this.m_strPais = "sem_país";
    }

    /**
     * Reescrita do método toString da classe Object,devolvendo na forma de
     * texto o objeto Local instânciado.
     *
     * @return texto informativo sobre Local
     */
    @Override
    public String toString() {
        String strLocal = "Local: " + this.m_strLocal
                + "\nCidade: " + this.m_strCidade
                + "\nPaís: " + this.m_strPais;
        return strLocal;
    }

    /**
     * Reescrita do método equals da classe Object,devolvendo um valor booleano.
     *
     * @return verdadeiro se o local a comparar é igual e falso no caso
     * contrário
     */
    @Override
    public boolean equals(Object obj) {
        Local l = (Local) obj;
        return (l.getM_strCidade().equalsIgnoreCase(this.m_strCidade)
                && l.getM_strLocal().equalsIgnoreCase(this.m_strLocal)
                && l.getM_strPais().equalsIgnoreCase(this.m_strPais));
    }

    /**
     * Procura o nome do local instânciado.
     *
     * @return nome do local
     */
    public String getM_strLocal() {
        return m_strLocal;
    }

    /**
     * Define o novo nome do local instânciado.
     *
     * @param novoStrLocal novo nome do local
     */
    public void setM_strLocal(String novoStrLocal) {
        this.m_strLocal = novoStrLocal;
    }

    /**
     * Procura o nome da cidade instânciada.
     *
     * @return nome da cidade
     */
    public String getM_strCidade() {
        return m_strCidade;
    }

    /**
     * Define o novo nome do local instânciado.
     *
     * @param novoStrCidade novo nome da cidade
     */
    public void setM_strCidade(String novoStrCidade) {
        this.m_strCidade = novoStrCidade;
    }

    /**
     * Procura o nome do país instânciado.
     *
     * @return nome do país
     */
    public String getM_strPais() {
        return m_strPais;
    }

    /**
     * Define o novo nome do local instânciado.
     *
     * @param novoStrPais novo nome do país
     */
    public void setM_strPais(String novoStrPais) {
        this.m_strPais = novoStrPais;
    }
}
