/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eventoscientificos;

import java.io.Serializable;
import states.EventoState;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import states.EventoCriadoState;
import states.SubmissaoArtigosParaRevisaoSubmetidosState;

/**
 *
 * @author Nuno Silva
 */
public class Evento implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private String m_strTitulo;
    private String m_strDescricao;
    private Local m_local;
    private String m_strDataInicio;
    private String m_strDataFim;
    private String m_strDataLimiteSubmissão;
    private List<Organizador> m_listaOrganizadores;
    private List<Submissao> m_listaSubmissoes;
    private CP m_cp;
    private List<Topico> m_listaTopicos;
    private EventoState state;
    private String dataLimiteRevisao;
    private int nMaxTopicos;
    private String dataLimiteRegisto;
    private ProcessoDistribuicao processoDistribuicao;
    private ValorRegistoNoEvento m_valorRegistoNoEvento;
    private RegistoNoEvento m_registoNoEvento;
    private ProcessoDecisao m_processoDecisao;

    public Evento() {
        m_local = new Local();
        m_listaOrganizadores = new ArrayList<Organizador>();
        m_listaSubmissoes = new ArrayList<Submissao>();
        m_listaTopicos = new ArrayList<Topico>();
        this.state = new EventoCriadoState(this);
    }

    public Evento(String titulo, String descricao) {
        m_local = new Local();
        m_listaOrganizadores = new ArrayList<Organizador>();
        m_listaSubmissoes = new ArrayList<Submissao>();
        m_listaTopicos = new ArrayList<Topico>();
        this.setTitulo(titulo);
        this.setDescricao(descricao);
    }
    
    public ValorRegistoNoEvento definirValorRegisto() {
        return this.m_valorRegistoNoEvento = new ValorRegistoNoEvento();
     }
    
    public ValorRegistoNoEvento getM_registoNoEvento() {
        return m_valorRegistoNoEvento;
    }

    public CP novaCP() {
        m_cp = new CP();

        return m_cp;
    }

    public final void setTitulo(String strTitulo) {
        this.m_strTitulo = strTitulo;
    }

    public final void setDescricao(String strDescricao) {
        this.m_strDescricao = strDescricao;
    }

    public void setDataInicio(String strDataInicio) {
        this.m_strDataInicio = strDataInicio;
    }

    public void setDataFim(String strDataFim) {
        this.m_strDataFim = strDataFim;
    }

    // adicionada na iteração 2
    public void setDataLimiteSubmissão(String strDataLimiteSubmissão) {
        this.m_strDataLimiteSubmissão = strDataLimiteSubmissão;
    }

    public String getDataLimiteRevisao() {
        return dataLimiteRevisao;
    }

    public void setDataLimiteRevisao(String dataLimiteRevisao) {
        this.dataLimiteRevisao = dataLimiteRevisao;
    }

    public void setLocal(String strLocal) {
        this.m_local.setM_strLocal(strLocal);;
    }


    public ProcessoDistribuicao getProcessoDistribuicao() {
        return processoDistribuicao;
    }

    public void setProcessoDistribuicao(ProcessoDistribuicao pd) {
        this.processoDistribuicao = pd;
    }
    
    public ProcessoDistribuicao novoProcessoDistribuicao() {
        processoDistribuicao = new ProcessoDistribuicao();
        return processoDistribuicao;
    }
        
     public ProcessoDecisao getProcessoDecisao() {
        return m_processoDecisao;
    }

    public void setProcessoDecisao(ProcessoDecisao pd) {
        this.m_processoDecisao = pd;
    }
    
    public ProcessoDecisao novoProcessoDecisao() {
        m_processoDecisao = new ProcessoDecisao();
        return m_processoDecisao;
    }
    public List<Organizador> getListaOrganizadores() {
        List<Organizador> lOrg = new ArrayList<Organizador>();

        for (ListIterator<Organizador> it = m_listaOrganizadores.listIterator(); it.hasNext();) {
            lOrg.add(it.next());
        }

        return lOrg;
    }

    public boolean addOrganizador(String strId, Utilizador u) {
        Organizador o = new Organizador(strId, u);

        o.valida();

        return addOrganizador(o);
    }

    private boolean addOrganizador(Organizador o) {
        return m_listaOrganizadores.add(o);
    }

    public boolean valida() {
        return true;
    }

    public void setCP(CP cp) {
        m_cp = cp;
    }

    @Override
    public String toString() {
        return this.m_strTitulo + "+ ...";
    }

    public boolean aceitaSubmissoes() {
        return true;
    }

    public Submissao novaSubmissao() {
        return new Submissao();
    }

    public boolean addSubmissao(Submissao submissao) {
        if (validaSubmissao(submissao)) {
            submissao.setState(new SubmissaoArtigosParaRevisaoSubmetidosState(submissao));
            return this.m_listaSubmissoes.add(submissao);

        } else {
            return false;
        }
    }

    private boolean validaSubmissao(Submissao submissao) {
        return submissao.valida();
    }

    public List<Submissao> getListaSubmissoes() {
        return this.m_listaSubmissoes;
    }

    public CP getCP() {
        return this.m_cp;
    }

    public List<Topico> getTopicos() {
        return m_listaTopicos;
    }

    public void setM_listaTopicos(List<Topico> m_listaTopicos) {
        this.m_listaTopicos = m_listaTopicos;
    }

    // adicionada na iteração 2
    public Topico novoTopico() {
        return new Topico();
    }

    // adicionada na iteração 2
    public boolean addTopico(Topico t) {
        return this.m_listaTopicos.add(t);
    }

    // adicionada na iteração 2
    public boolean validaTopico(Topico t) {
        if (validaGlobalTopico(t)) {
            return true;
        } else {
            return false;
        }
    }

    // adicionada na iteração 2
    private boolean validaGlobalTopico(Topico t) {
        return true;
    }

    public EventoState getState() {
        return state;
    }

    public void setState(EventoState state) {
        this.state = state;
    }

    public String getM_strTitulo() {
        return m_strTitulo;
    }

    public String getM_strDescricao() {
        return m_strDescricao;
    }

    public Local getM_local() {
        return m_local;
    }

    public String getM_strDataInicio() {
        return m_strDataInicio;
    }

    public String getM_strDataFim() {
        return m_strDataFim;
    }

    /**
     * devolve numero máximo de tópicos por Artigo
     *
     * @return numero inteiro máximo de tópicos por Artigo
     */
    public int getnMaxTopicos() {
        return nMaxTopicos;
    }

    /**
     * modifica numero máximo de tópicos por Artigo
     *
     * @param nMaxTopicos numero inteiro
     */
    public void setnMaxTopicos(int nMaxTopicos) {
        this.nMaxTopicos = nMaxTopicos;
    }

    /**
     * devolve Data limite de registo
     *
     * @return String Data limite de registo
     */
    public String getDataLimiteRegisto() {
        return dataLimiteRegisto;
    }

    /**
     * modifica Data limite de registo
     *
     * @param dataLimiteRegisto String
     */
    public void setDataLimiteRegisto(String dataLimiteRegisto) {
        this.dataLimiteRegisto = dataLimiteRegisto;
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
        final Evento other = (Evento) obj;
        if (!Objects.equals(this.m_strTitulo, other.m_strTitulo)) {
            return false;
        }
        if (!Objects.equals(this.m_strDescricao, other.m_strDescricao)) {
            return false;
        }
        if (!Objects.equals(this.m_local, other.m_local)) {
            return false;
        }
        if (!Objects.equals(this.m_strDataInicio, other.m_strDataInicio)) {
            return false;
        }
        if (!Objects.equals(this.m_strDataFim, other.m_strDataFim)) {
            return false;
        }
        if (!Objects.equals(this.m_listaOrganizadores, other.m_listaOrganizadores)) {
            return false;
        }
        if (!Objects.equals(this.m_cp, other.m_cp)) {
            return false;
        }
        return true;
    }

    /**
     * Obtém a lista de tópicos
     * @return List<Topico>
     */
    public List<Topico> getM_listaTopicos() {
        return m_listaTopicos;
    }
    
    /**
     * Retorna uma submissão da lista de submissões
     * @param artigo
     * @return submissao
     */
    public Submissao getSubmissao(Artigo artigo){
        for (Submissao submissao : this.getListaSubmissoes()) {
            if(submissao.getArtigo().equals(artigo))
                return submissao;
        }
        return null;
    }

}
