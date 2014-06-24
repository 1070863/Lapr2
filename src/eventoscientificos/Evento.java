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
public class Evento implements Serializable {

    private static final long serialVersionUID = 1L;

    private String m_strTitulo;
    private String m_strDescricao;
    private Local m_local;
    private String m_strDataInicio;
    private String m_strDataFim;
    private String m_strDataLimiteSubmissao;
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
    private List<RegistoNoEvento> m_listRegistoNoEvento;
    private ProcessoDecisao m_processoDecisao;
    private String m_strDataLimiteSubmissaoFinal;
    private String ID;

    /**
     * Obtém o ID do evento. O ID é utilizado na importação de dados (migração
     * de dados)
     *
     * @return ID
     */
    public String getID() {
        return ID;
    }

    /**
     * Atribui um ID. Utilizado na importação de dados (migração de dados)
     *
     * @param ID
     */
    public void setID(String ID) {
        this.ID = ID;
    }

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
    public void setDataLimiteSubmissao(String strDataLimiteSubmissao) {
        this.m_strDataLimiteSubmissao = strDataLimiteSubmissao;
    }

    public String getDataLimiteSubmissao() {
        return m_strDataLimiteSubmissao;
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

    public void setCidade(String strCidade) {
        this.m_local.setM_strCidade(strCidade);
    }

    public void setPais(String strPais) {
        this.m_local.setM_strPais(strPais);
    }

    public String getDataLimiteSubmissaoFinal() {
        return m_strDataLimiteSubmissaoFinal;
    }

    public void setDataLimiteSubmissaoFinal(String m_strDataLimiteSubmissaoFinal) {
        this.m_strDataLimiteSubmissaoFinal = m_strDataLimiteSubmissaoFinal;
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
        System.out.println("addOrganizador");
        System.out.println("addOrganizador: " + o.valida(u));
        if (o.valida(u) && validaOrganizador(o)) {
            return addOrganizador(o);
        } else {
            return false;
        }
    }

    private boolean addOrganizador(Organizador o) {
        return m_listaOrganizadores.add(o);
    }

    public boolean valida() {
        return true;
    }

    public boolean validaOrganizador(Organizador org) {
        for (Organizador o : this.getListaOrganizadores()) {
            if (o.getM_utilizador().getM_strEmail().equalsIgnoreCase(org.getM_utilizador().getM_strEmail())) {
                return false;
            }
        }
        return true;
    }

    public void setCP(CP cp) {
        m_cp = cp;
    }

    public boolean aceitaSubmissoes() {
        return true;
    }

    public Submissao novaSubmissao() {
        return new Submissao();
    }

    /**
     * Cria uma instância do tipo Registo no Evento.
     *
     * @return objeto do tipo Registo no Evento
     */
    public RegistoNoEvento novoRegisto() {
        return new RegistoNoEvento();
    }

    /**
     * Adiciona um objeto do tipo Registo no Evento à lista de Registos no
     * Evento.
     *
     * @param novoRegisto novo Registo no Evento
     * @return Verdadeiro se adicionado e falso no caaso contrário
     */
    public boolean addRegistoNoEvento(RegistoNoEvento novoRegisto) {
        return this.m_listRegistoNoEvento.add(novoRegisto);
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

    /**
     * Procura a lista de Registos no evento
     *
     * @return lista de registos no evento
     */
    public List<RegistoNoEvento> getListaRegistos() {
        return this.m_listRegistoNoEvento;
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
     *
     * @return List<Topico>
     */
    public List<Topico> getM_listaTopicos() {
        return m_listaTopicos;
    }

    /**
     * Retorna uma submissão da lista de submissões
     *
     * @param artigo
     * @return submissao
     */
    public Submissao getSubmissao(Artigo artigo) {
        for (Submissao submissao : this.getListaSubmissoes()) {
            if (submissao.getArtigo().equals(artigo)) {
                return submissao;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Titulo:" + m_strTitulo
                + "\n Descricao:" + m_strDescricao
                + "\n Local:" + m_local.toString()
                + "\n DataInicio:" + m_strDataInicio
                + "\n DataFim:" + m_strDataFim
                + "\n DataLimiteSubmissão:" + m_strDataLimiteSubmissao
                + "\n DataLimiteRevisão:" + dataLimiteRevisao
                + "\n DataLimiteRegisto:" + dataLimiteRegisto
                + "\n DataLimiteSubmissaoFinal:" + m_strDataLimiteSubmissaoFinal
                + "\n ListaOrganizadores:" + m_listaOrganizadores
                + "\n Numero máximo de topicos:" + nMaxTopicos;
    }

    public List<Organizador> getM_listaOrganizadores() {
        return m_listaOrganizadores;
    }

}
