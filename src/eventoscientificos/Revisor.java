package eventoscientificos;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta classe cria e gere a informação de um Revisor.
 *
 * @author Grupo66 LAPR2
 */
public class Revisor {

    /**
     * Atributos do Revisor
     */
    private String m_strNome;
    private Utilizador m_utilizador;
    private List<Topico> m_listaTopicos;

    /**
     * Construtor completo quando recebe por parêmtro o Utilizador que passa a
     * ser Revisor.
     *
     * @param u
     */
    public Revisor(Utilizador u) {
        this.m_strNome = u.getM_strNome();
        this.m_utilizador = u;
        this.m_listaTopicos = new ArrayList<>();
    }

    /**
     * Construtor por omissão de parêmtros.
     */
    public Revisor() {
        this.m_strNome = "sem_nome";
        this.m_utilizador = new Utilizador();
        this.m_listaTopicos = new ArrayList<>();
    }

    /**
     * Procura o nome do Revisor instânciado.
     *
     * @return nome do Revisor
     */
    public String getM_strNome() {
        return this.m_strNome;
    }

    /**
     * Define o nome do Revisor.
     *
     * @param m_strNome nome do Revisor
     */
    public void setM_strNome(String m_strNome) {
        this.m_strNome = m_strNome;
    }

    /**
     * Procura o Utilizador intânciado em Revisor.
     *
     * @return objeto do tipo Utilizador
     */
    public Utilizador getM_utilizador() {
        return this.m_utilizador;
    }

    /**
     * Define o Utilizador que é Revisor.
     *
     * @param m_utilizador objeto do tipo Utilizador
     */
    public void setM_utilizador(Utilizador m_utilizador) {
        this.m_utilizador = m_utilizador;
    }

    /**
     * Procura a lista de tópicos de pericia do Revisor.
     *
     * @return lista de tópicos de perícia
     */
    public List<Topico> getM_listaTopicos() {
        return this.m_listaTopicos;
    }

    /**
     * Define a lista de tópicos de perícia do Revisor.
     *
     * @param listaTopicos lista com tópicos de perícia
     */
    public void setM_listaTopicos(List<Topico> listaTopicos) {
        this.m_listaTopicos.addAll(listaTopicos);
    }

    /**
     * Reescrita da classe toString herdade da classe Object e que cria um
     * String com a informação do Revisor e os seus tópicos de perícia.
     *
     * @return informação do Revisor
     */
    @Override
    public String toString() {
        String strRevisor = m_utilizador.toString() + ": ";

        String strTopicos = "";
        for (Topico t : m_listaTopicos) {
            strTopicos += t.toString();
        }
        strRevisor += strTopicos;
        return strRevisor;
    }

    /**
     * Valida a existência do utilizador instânciado.
     *
     * @return verdade se existir e falso se não existir.
     */
    public boolean valida() {
        return (this.m_utilizador.validaEmail());
    }
}
