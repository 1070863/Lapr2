package eventoscientificos;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author Lopes
 */
public class RegistoEventos implements Serializable{
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

    private boolean validaEvento(Evento e) {
        return true;
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

}
