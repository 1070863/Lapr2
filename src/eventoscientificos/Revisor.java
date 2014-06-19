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
     * Atributos de instância.
     */
    private String m_strNome;
    private Utilizador m_utilizador;
    private List<Topico> m_listaTopicos;
    
    /**
     * confianca: confiança do revisor no tópico do artigo
     * adequacao: Adequação ao evento
     * originalidade: originalidade do artigo
     * qualidade: qualidade de apresentação
     * recomendacao: recomendação global aceite/rejeitado
     */
    private String confianca;
    private String adequacao;
    private String originalidade;
    private String qualidade;
    private boolean recomendacao;
    /**
     * textoJustificativo: texto justificativo da revisão
     */
    private String textoJustificativo;

    /**
     * Construtor completo quando recebe por parêmtro o Utilizador que passa a
     * ser Revisor.
     *
     * @param u Objeto do tipo Utilizador
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

    public String getConfianca() {
        return confianca;
    }

    public void setConfianca(String confianca) {
        this.confianca = confianca;
    }

    public String getAdequacao() {
        return adequacao;
    }

    public void setAdequacao(String adequacao) {
        this.adequacao = adequacao;
    }

    public String getOriginalidade() {
        return originalidade;
    }

    public void setOriginalidade(String originalidade) {
        this.originalidade = originalidade;
    }

    public String getQualidade() {
        return qualidade;
    }

    public void setQualidade(String qualidade) {
        this.qualidade = qualidade;
    }

    public boolean getRecomendacao() {
        return recomendacao;
    }

    public void setRecomendacao(boolean recomendacao) {
        this.recomendacao = recomendacao;
    }

    public String getTextoJustificativo() {
        return textoJustificativo;
    }

    public void setTextoJustificativo(String textoJustificativo) {
        this.textoJustificativo = textoJustificativo;
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
     * Reescrita da classe toString herdada da classe Object e que cria um
     * String com a informação do Revisor e os seus tópicos de perícia.
     *
     * @return informação do Revisor
     */
    @Override
    public String toString() {
        String strRevisor = m_utilizador.getM_strNome() + ": ";

        String strTopicos = "";
        for (Topico t : m_listaTopicos) {
            strTopicos += t.toString();
        }
        strRevisor += strTopicos;
        return strRevisor;
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
        } else if (obj instanceof Revisor) {
            Revisor aux = (Revisor) obj;
            return this.m_utilizador.equals(aux.m_utilizador);
        } else {
            return false;
        }
    }
}
