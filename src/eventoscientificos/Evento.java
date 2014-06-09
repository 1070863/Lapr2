/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eventoscientificos;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

/**
 *
 * @author Nuno Silva
 */
public class Evento {

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
    private SubmissaoCriadaState submissaoState;

    public Evento() {
        m_local = new Local();
        m_listaOrganizadores = new ArrayList<Organizador>();
        m_listaSubmissoes = new ArrayList<Submissao>();
        m_listaTopicos = new ArrayList<Topico>();
    }

    public Evento(String titulo, String descricao) {
        m_local = new Local();
        m_listaOrganizadores = new ArrayList<Organizador>();
        m_listaSubmissoes = new ArrayList<Submissao>();
        m_listaTopicos = new ArrayList<Topico>();
        this.setTitulo(titulo);
        this.setDescricao(descricao);
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
            submissaoState.SetArtigosParaRevisaoSubmetidos();
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
        if (t.valida() && validaGlobalTopico(t)) {
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
        return true;
    }

    
    
}
