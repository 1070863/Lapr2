package eventoscientificos;

/**
 * Classe responsável pela criação e gestão de um Organizador criando.
 *
 * @author Grupo 66 LPR2
 */
public class Organizador {

    /**
     * Atributos de instância.
     */
    private final String m_strNome;
    private Utilizador m_utilizador;

    /**
     * Cria objeto do tipo Organizador quando todos os atributos são passados
     * por parâmetros.
     *
     * @param strId email ou username do Utilizador
     * @param u objeto do tipo do Utilizador
     */
    public Organizador(String strId, Utilizador u) {
        this.m_strNome = u.getM_strNome();
        this.m_utilizador = u;
    }

    /**
     * Cria objeto do tipo Utilizador por omissão de atributos nos parâmetros.
     */
    public Organizador() {
        this.m_strNome = "sem nome";
        this.m_utilizador = null;
    }

    /**
     * Procura objeto do tipo Utilizador.
     *
     * @return objeto do tipo Utilizador
     */
    public Utilizador getM_utilizador() {
        return m_utilizador;
    }

    /**
     * Define o Utilizador.
     *
     * @param m_utilizador objeto do tipo Utilizador
     */
    public void setM_utilizador(Utilizador m_utilizador) {
        this.m_utilizador = m_utilizador;
    }

    /**
     * 
     * @return 
     */
    public boolean valida() {
        return true;//FALTA TRATAR
    }
    /**
     * Reecrita do método to String herdado da classe Object e que devolve uma
     * String com texto informativo do Organizador.
     *
     * @return informação do Organizador
     */
    @Override
    public String toString() {
        return m_utilizador.toString();
    }

}
