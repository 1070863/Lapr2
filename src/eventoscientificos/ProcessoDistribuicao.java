package eventoscientificos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import states.EventoCriadoState;

/**
 * Classe responsável pela distribuição/atribuição de revisores a artigos. 
 * 
 * @author Grupo 66 LPR2
 */
public class ProcessoDistribuicao implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * Atributos de instância.
     */
    private MecanismoDistribuicao mecanismoDistribuicao;
    private List<Distribuicao> m_listaDistribuicao;
    private List<Submissao> m_listaSubmissoes;
    private CP m_cp;
    private Distribuicao m_distribuicao;

     public ProcessoDistribuicao() {
         m_listaDistribuicao = new ArrayList();
    }
    /**
     * Define o mecanismo de distribuição a utilizar
     *
     * @param m identificador do mecanismo
     */
    public void setMecanismoDistribuicao(int m) {
        if (m == 1) {
            mecanismoDistribuicao = new Mecanismo1();
        }
    }
    /**
     * Cria lista de distribuição conforme mecanismo definido.
     */
    public List<Distribuicao> distribui() {
        m_listaDistribuicao = mecanismoDistribuicao.distribui(this);
        return m_listaDistribuicao;
    }
    
      /**
     * Cria uma nova distribuição e a lista de revisores que vai ter
     *
     * @return nova distribuicao
     */
    public Distribuicao novaDistribuicao() {
        m_distribuicao = new Distribuicao();

        return m_distribuicao;
    }
    /**
     * @return lista com distribuições
     */
    public List<Distribuicao> getM_listaDistribuicao() {
        return m_listaDistribuicao;
    }

    public void setM_listaDistribuicao(List<Distribuicao> m_listaDistribuicao) {
        this.m_listaDistribuicao = m_listaDistribuicao;
    }
    
     /**
     * @return lista com submissões
     */
    public List<Submissao> getM_listaSubmissoes() {
        return m_listaSubmissoes;
    }

    /**
     * Define Comissão do programa do Processo de Distribuição.
     *
     * @param m_listaSubmissoes lista de Submissões
     *
     */
    public void setM_listaSubmissoes(List<Submissao> m_listaSubmissoes) {
        this.m_listaSubmissoes = m_listaSubmissoes;
    }  
    /**
     * @return distribuição actual
     */
    public Distribuicao getM_distribuicao() {
        return m_distribuicao;
    }

    /**
     * Define a distribuição
     *
     * @param m_distribuicao Objecto do tipo Distribuicao
     */
    public void setM_distribuicao(Distribuicao m_distribuicao) {
        this.m_distribuicao = m_distribuicao;
    }    
    /**
     * @return mecanismo de distribuição definido
     */
    public MecanismoDistribuicao getMecanismoDistribuicao() {
        return mecanismoDistribuicao;
    }
    /**
     * Define o mecanismo de distribuição
     *
     * @param mecanismoDistribuicao Objecto do tipo MecanismoDistribuicao
     */
    public void setMecanismoDistribuicao(MecanismoDistribuicao mecanismoDistribuicao) {
        this.mecanismoDistribuicao = mecanismoDistribuicao;
    }
    /**
     * @return CP
     */
    public CP getM_cp() {
        return m_cp;
    }
    /**
     * Define a comissão de programa
     *
     * @param m_cp Objecto do tipo CP
     */
    public void setM_cp(CP m_cp) {
        this.m_cp = m_cp;
    }
        
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProcessoDistribuicao other = (ProcessoDistribuicao) obj;
        if (!Objects.equals(this.mecanismoDistribuicao, other.mecanismoDistribuicao)) {
            return false;
        }
//        if (mecanismoDistribuicao.getClass().equals(obj)){
//            return true;
//        }
        return true;
    }
    
    
}
