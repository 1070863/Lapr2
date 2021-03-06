package eventoscientificos;

import java.io.Serializable;
import java.util.*;
import states.EventoCameraReadyState;
import states.EventoCriadoFicheiroState;
import states.EventoDecididoState;
import states.EventoRegistadoState;
import states.EventoTopicosDefinidosState;
import states.EventoValoresRegistoDefinidos;
import states.SubmissaoAceiteState;
import states.SubmissaoNotificadaAceiteState;
import states.SubmissaoRejeitadaState;

/**
 * Classe responsável pelo processo de registo de eventos.
 *
 * @author Grupo 66 LAPR2
 */
public class RegistoEventos implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Atributos de instância.
     */
    private List<Evento> m_listaEventos;
    private Empresa m_empresa;
    private List<MecanismoDistribuicao> m_listaMecanismoDistribuicao;
    private MecanismoDistribuicao m_MecanismoDistribuicao;
    private List<MecanismoDecisao> m_listaMecanismoDecisao;

    /**
     * Construtor por criar um no Registo de Eventos para a empresa.
     *
     * @param m_empresa Empresa a ser definida
     */
    public RegistoEventos(Empresa empresa) {
        this.m_listaEventos = new ArrayList<>();
        this.m_empresa = empresa;
    }

    /**
     * Cria um novo objecto Evento
     *
     * @return Evento
     */
    public Evento novoEvento() {
        return new Evento();
    }

    /**
     * @return m_listaMecanismoDistribuicao lista com mecanimos de distribuição
     * disponíveis
     */
    public List<MecanismoDistribuicao> getM_listaMecanismoDistribuicao() {
        return m_listaMecanismoDistribuicao;
    }

    /**
     * Define a lista de mecanismos de distribuição disponíveis
     *
     * @param m_listaMecanismoDistribuicao Objecto do tipo
     * List<MecanismoDistribuicao>
     */
    public void setM_listaMecanismoDistribuicao(List<MecanismoDistribuicao> m_listaMecanismoDistribuicao) {
        this.m_listaMecanismoDistribuicao = m_listaMecanismoDistribuicao;
    }

    /**
     * @return m_MecanismoDistribuicao, mecanismo de distribuição definido
     */
    public MecanismoDistribuicao getMd() {
        return m_MecanismoDistribuicao;
    }

    /**
     * Define o mecanismo de distribuição disponível
     *
     * @param md Objecto do tipo MecanismoDistribuicao
     */
    public void setMd(MecanismoDistribuicao md) {
        this.m_MecanismoDistribuicao = md;
    }

    /**
     * Regista um evento na lista de eventos após validação.
     *
     * @return true se evento válido e adicionado com sucesso.
     */
    public boolean registaEvento(Evento e) {
        if (validaEvento(e)) {
            return addEvento(e);
        } else {
            return false;
        }
    }

    /**
     * Regista um evento na lista de eventos.
     *
     * @return true se evento adicionado com sucesso.
     */
    private boolean addEvento(Evento e) {
        return m_listaEventos.add(e);
    }

    /**
     * Cria uma nova lista de mecanismos de distribuição disponíveis e atribui
     * mecanismos à lista
     *
     * @return m_listaMecanismoDistribuicao lista criada
     */
    public List<MecanismoDistribuicao> criarListaMecanismoDistribuicaos() {
        m_listaMecanismoDistribuicao = new ArrayList<>();
        this.m_listaMecanismoDistribuicao.add(new Mecanismo1());
        return m_listaMecanismoDistribuicao;
    }

    /**
     * Cria uma nova lista de mecanismos de decisão disponíveis e atribui
     * mecanismos à lista
     *
     * @return m_listaMecanismoDistribuicao lista criada
     */
    public List<MecanismoDecisao> criarListaMecanismoDecisao() {
        m_listaMecanismoDecisao = new ArrayList<>();
        this.m_listaMecanismoDecisao.add(new MecanismoDecisao1());
        return m_listaMecanismoDecisao;

    }

    /**
     * Procura no registo de eventos os eventos cujo Autor tenha Submissões e as
     * mesmas tenham o seu estado como aceite.
     *
     * @param strId id do autor correspondente
     * @return Lista de Eventos com Submissões aceites.
     */
    public List<Evento> getEventosAutorAceites(String strId) {
        List<Evento> leAutorAceites = new ArrayList<>();

        Utilizador u = m_empresa.getM_registaUtilizador().getUtilizador(strId);
        if (u != null) {
            for (Iterator<Evento> it = m_listaEventos.listIterator(); it.hasNext();) {
                Evento e = it.next();
                List<Submissao> lSubmissoes = e.getListaSubmissoes();

                boolean bRet = false;
                if (!leAutorAceites.contains(e)) {
                    for (Submissao sub : lSubmissoes) {
                        if ((sub.getArtigo().getAutorCorrespondente().getUtilizador().equals(u)) && (sub.getState() instanceof SubmissaoAceiteState)) {
                            bRet = true;
                            break;
                        }
                    }
                    if (bRet) {
                        leAutorAceites.add(e);
                    }
                }
            }
        }
        return leAutorAceites;
    }

    /**
     * Procura no registo de eventos os eventos cujo organizador tenha a id
     * indicada e os eventos tenham a data de registo ultrapassada.
     *
     * @param strId id do autor correspondente
     * @return Lista de Eventos com Submissões aceites.
     */
    public List<Evento> getEventosOrgDataRegistoPassada(String strId) {
        List<Evento> leOrganizador = new ArrayList<>();

        Utilizador u = m_empresa.getM_registaUtilizador().getUtilizador(strId);

        if (u != null) {
            for (Iterator<Evento> it = m_listaEventos.listIterator(); it.hasNext();) {
                Evento e = it.next();
                List<Organizador> lOrg = e.getListaOrganizadores();

                boolean bRet = false;
                if (!leOrganizador.contains(e) && e.getState() instanceof EventoCameraReadyState) {
                    for (Organizador org : lOrg) {
                        if (org.getM_utilizador().equals(u)) {
                            bRet = true;
                            break;
                        }
                    }
                    if (bRet) {
                        leOrganizador.add(e);
                    }
                }
            }
        }
        return leOrganizador;
    }

    /**
     * Procura no registo de eventos os eventos cujo organizador tenha a id
     * indicada e os eventos tenham já tópicos definidos.
     *
     * @param strId id do autor correspondente
     * @return Lista de Eventos com Tópicos definidos
     */
    public List<Evento> getEventosOrgTopicosDef(String strId) {
        List<Evento> leOrganizador = new ArrayList<>();

        Utilizador u = m_empresa.getM_registaUtilizador().getUtilizador(strId);

        if (u != null) {
            for (Iterator<Evento> it = m_listaEventos.listIterator(); it.hasNext();) {
                Evento e = it.next();
                List<Organizador> lOrg = e.getListaOrganizadores();

                boolean bRet = false;
                if (!leOrganizador.contains(e) && e.getState() instanceof EventoTopicosDefinidosState) {
                    for (Organizador org : lOrg) {
                        if (org.getM_utilizador().equals(u)) {
                            bRet = true;
                            break;
                        }
                    }
                    if (bRet) {
                        leOrganizador.add(e);
                    }
                }
            }
        }
        return leOrganizador;
    }

    /**
     * Procura no registo de eventos os eventos cujo organizador tenha a id
     * indicada e os eventos tenham já tópicos definidos.
     *
     * @param strId id do autor correspondente
     * @return Lista de Eventos com Tópicos definidos
     */
    public List<Evento> getEventosOrgValoresDef(String strId) {
        List<Evento> leOrganizador = new ArrayList<>();

        Utilizador u = m_empresa.getM_registaUtilizador().getUtilizador(strId);

        if (u != null) {
            for (Iterator<Evento> it = m_listaEventos.listIterator(); it.hasNext();) {
                Evento e = it.next();
                List<Organizador> lOrg = e.getListaOrganizadores();

                boolean bRet = false;
                if (!leOrganizador.contains(e) && e.getState() instanceof EventoValoresRegistoDefinidos) {
                    for (Organizador org : lOrg) {
                        if (org.getM_utilizador().equals(u)) {
                            bRet = true;
                            break;
                        }
                    }
                    if (bRet) {
                        leOrganizador.add(e);
                    }
                }
            }
        }
        return leOrganizador;
    }

    /**
     * Procura no registo de eventos os eventos cujo organizador tenha a id
     * indicada e os eventos tenham o seu estado definido como registado.
     *
     * @param strId id do autor correspondente
     * @return Lista de Eventos com estado Registado
     */
    public List<Evento> getEventosOrgRegistados(String strId) {
        List<Evento> leOrganizador = new ArrayList<>();

        Utilizador u = m_empresa.getM_registaUtilizador().getUtilizador(strId);

        if (u != null) {
            for (Iterator<Evento> it = m_listaEventos.listIterator(); it.hasNext();) {
                Evento e = it.next();
                List<Organizador> lOrg = e.getListaOrganizadores();

                boolean bRet = false;
                if (!leOrganizador.contains(e) && e.getState() instanceof EventoRegistadoState) {
                    for (Organizador org : lOrg) {
                        if (org.getM_utilizador().equals(u)) {
                            bRet = true;
                            break;
                        }
                    }
                    if (bRet) {
                        leOrganizador.add(e);
                    }
                }
            }
        }
        return leOrganizador;
    }

    /**
     * Procura no registo de eventos os eventos cujo organizador tenha a id
     * indicada.
     *
     * @param strId id do organizador correspondente
     * @return Lista de Eventos do organizador pedido
     */
    public List<Evento> getEventosOrganizador(String strId) {
        List<Evento> leOrganizador = new ArrayList<>();

        Utilizador u = m_empresa.getM_registaUtilizador().getUtilizador(strId);

        if (u != null) {
            for (Iterator<Evento> it = m_listaEventos.listIterator(); it.hasNext();) {
                Evento e = it.next();
                List<Organizador> lOrg = e.getListaOrganizadores();

                boolean bRet = false;
                if (!leOrganizador.contains(e)) {
                    for (Organizador org : lOrg) {
                        if (org.getM_utilizador().equals(u)) {
                            bRet = true;
                            break;
                        }
                    }
                    if (bRet) {
                        leOrganizador.add(e);
                    }
                }
            }
        }
        return leOrganizador;
    }

    /**
     * Procura no registo de eventos todos aqueles que aceitam submissões
     *
     * @return Lista de Eventos que estão a aceitar submissões
     */
    public List<Evento> getListaEventosPodeSubmeter() {
        List<Evento> le = new ArrayList<>();

        for (Evento e : m_listaEventos) {
            if (!le.contains(e)) {
                if (e.aceitaSubmissoes()) {
                    le.add(e);
                }
            }
        }

        return le;
    }

    /**
     * Devolve evento da lista de eventos com titulo pedida
     *
     * @param eventoTitulo título do evento
     * @return e Evento com título pedido. null no caso de não haver nenhum
     * evento com esse título
     */
    public Evento getEvento(String eventoTitulo) {

        for (Evento e : m_listaEventos) {
            if (e.getM_strTitulo() != null) {
                if (eventoTitulo.equalsIgnoreCase(e.getM_strTitulo())) {
                    return e;
                }
            }
        }
        return null;
    }

    /**
     * Devolve evento da lista de eventos com id pedida
     *
     * @param eventoID id do evento
     * @return e Evento com título pedido. null no caso de não haver nenhum
     * evento com esse título
     */
    public Evento getEventoPorId(String eventoID) {

        for (Evento e : m_listaEventos) {
            if (e.getID() != null) {
                if (eventoID.equalsIgnoreCase(e.getID())) {
                    return e;
                }
            }
        }
        return null;
    }

    /**
     * Devolve evento válido ou não
     *
     * @param e Evento a validar
     * @return true se título de evento é único e false no caso contrário.
     */
    private boolean validaEvento(Evento e) {
        if (this.getEvento(e.getM_strTitulo()) == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final RegistoEventos other = (RegistoEventos) obj;
        if (!Objects.equals(this.m_listaEventos, other.m_listaEventos)) {
            return false;
        }
        return true;
    }

    /**
     * @return m_listaEventos actual
     */
    public List<Evento> getM_listaEventos() {
        return m_listaEventos;
    }

    /**
     * Retorna a lista de eventos prontos a notificar
     *
     * @param strId
     * @return List<Evento>
     */
    public List<Evento> getListaEventosProntosNotificar(String strId) {
        List<Evento> le = new ArrayList<>();

        for (Evento e : getEventosOrganizador(strId)) {
            for (Submissao submissao : e.getListaSubmissoes()) {
                if (e.getState() instanceof EventoDecididoState
                        && submissao.getState() instanceof SubmissaoNotificadaAceiteState
                        || submissao.getState() instanceof SubmissaoRejeitadaState) {
                    le.add(e);
                }
            }
        }
        return le;
    }

    /**
     * Retorna número de eventos em estado CriadoFicheiro. Necessário para saber
     * se ficheiro carregado contém ou não eventos válidos
     *
     * @return número de eventos criados do ficheiro actualmente registados.
     */
    public int getListaEventosCriadoFicheiroSize() {
        int contador = 0;
        for (Evento e : m_listaEventos) {
            if (e.getState() instanceof EventoCriadoFicheiroState) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Apaga eventos em estado "CriadoFicheiro".
     */
    public void apagaEventosCriadoFicheiro() {

        for (int i = m_listaEventos.size() - 1; i > -1; i--) {
            Evento e = m_listaEventos.get(i);

            if (e.getState() instanceof EventoCriadoFicheiroState) {
                this.m_listaEventos.remove(e);
            }

        }
    }

}
