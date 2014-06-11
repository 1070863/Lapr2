package eventoscientificos;

import java.util.*;

/**
 *
 * @author Lopes
 */
public class RegistoEventos {

    private List<Evento> m_listaEventos;
    private Empresa m_empresa;

    public RegistoEventos(Empresa empresa) {
        this.m_listaEventos = new ArrayList<>();
        this.m_empresa = empresa;
    }

    public Evento novoEvento() {
        return new Evento();
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

    public List<Evento> getEventosOrganizador(String strId) {
        List<Evento> leOrganizador = new ArrayList<>();

        Utilizador u = m_empresa.getM_registaUtilizador().getUtilizador(strId);

        if (u != null) {
            for (Iterator<Evento> it = m_listaEventos.listIterator(); it.hasNext();) {
                Evento e = it.next();
                List<Organizador> lOrg = e.getListaOrganizadores();

                boolean bRet = false;
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
        return leOrganizador;
    }

    public List<Evento> getListaEventosPodeSubmeter() {
        List<Evento> le = new ArrayList<>();

        for (Evento e : m_listaEventos) {
            if (e.aceitaSubmissoes()) {
                le.add(e);
            }
        }

        return le;
    }
    
    /**
     * Procura um evento pelo ID
     * @param eventoID
     * @return Evento
     */
    public Evento getEvento(String eventoID){
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
