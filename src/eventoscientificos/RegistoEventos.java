package eventoscientificos;

import java.io.Serializable;
import java.util.*;
import states.EventoCriadoFicheiroState;
import states.EventoDecididoState;
import states.SubmissaoAceiteState;
import states.SubmissaoNotificadaAceiteState;
import states.SubmissaoRejeitadaState;

/**
 *
 * @author Lopes
 */
public class RegistoEventos implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Evento> m_listaEventos;
    private Empresa m_empresa;
    private List<MecanismoDistribuicao> m_listaMecanismoDistribuicao;
    private MecanismoDistribuicao m_MecanismoDistribuicao;
    private List<MecanismoDecisao> m_listaMecanismoDecisao;

    public RegistoEventos(Empresa empresa) {
        this.m_listaEventos = new ArrayList<>();
        this.m_empresa = empresa;
    }

    public Evento novoEvento() {
        return new Evento();
    }

    public List<MecanismoDistribuicao> getM_listaMecanismoDistribuicao() {
        return m_listaMecanismoDistribuicao;
    }

    public void setM_listaMecanismoDistribuicao(List<MecanismoDistribuicao> m_listaMecanismoDistribuicao) {
        this.m_listaMecanismoDistribuicao = m_listaMecanismoDistribuicao;
    }

    public MecanismoDistribuicao getMd() {
        return m_MecanismoDistribuicao;
    }

    public void setMd(MecanismoDistribuicao md) {
        this.m_MecanismoDistribuicao = md;
    }

    public boolean registaEvento(Evento e) {
        if (e.valida() && validaEvento(e)) {
            return addEvento(e);
        } else {
            return false;
        }
    }


    private boolean addEvento(Evento e) {
        return m_listaEventos.add(e);
    }

    public List<MecanismoDistribuicao> criarListaMecanismoDistribuicaos() {
        m_listaMecanismoDistribuicao = new ArrayList<>();
        this.m_listaMecanismoDistribuicao.add(new Mecanismo1());
        return m_listaMecanismoDistribuicao;
    }

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

    public List<Evento> getListaEventosProntosNotificar() {
        List<Evento> le = new ArrayList<>();

        for (Evento e : m_listaEventos) {
            //  if (e.aceitaNotificar()) 
            le.add(e);
        }
        return le;
    }

    public Evento getEvento(String eventoID) {
        for (Evento e : m_listaEventos) {
            if (eventoID.equalsIgnoreCase(e.getM_strTitulo())) {
                return e;
            }
        }
        return null;
    }

    
    private boolean validaEvento(Evento e) {
        if(this.getEvento(e.getM_strTitulo()) == null)
            return true;
        else
             return false; 
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

    public List<Evento> getM_listaEventos() {
        return m_listaEventos;
    }
    
    /**
     * Retorna a lista de eventos prontos a notificar
     * @param strId
     * @return List<Evento>
     */
    public List<Evento> getListaEventosProntosNotificar(String strId) {
        List<Evento> le = new ArrayList<>();

        for (Evento e : getEventosOrganizador(strId)) 
        {
            for (Submissao submissao : e.getListaSubmissoes())
            {
                    if(e.getState() instanceof EventoDecididoState &&
                            submissao.getState() instanceof SubmissaoNotificadaAceiteState || 
                            submissao.getState() instanceof SubmissaoRejeitadaState)
            le.add(e);
            }
        }    
        return le;
    }
    
    public void apagaEventosCriadoFicheiro(){

        int contador = 0;
        for (int i=m_listaEventos.size()-1; i> -1; i--) {
            Evento e = m_listaEventos.get(i);

            if(e.getState() instanceof EventoCriadoFicheiroState)
            {
                this.m_listaEventos.remove(e);
                contador++;
            }
        }
    }
}
