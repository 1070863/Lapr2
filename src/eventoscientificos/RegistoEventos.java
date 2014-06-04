package eventoscientificos;

import java.util.*;

/**
 *
 * @author Lopes
 */
public class RegistoEventos {

    private List<Evento> m_listaEventos;
    private Empresa m_empresa;

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
        List<Evento> leOrganizador = new ArrayList<Evento>();

        Utilizador u = m_empresa.getM_registaUtilizador().getUtilizador(strId);

        if (u != null) {
            for (Iterator<Evento> it = m_listaEventos.listIterator(); it.hasNext();) {
                Evento e = it.next();
                List<Organizador> lOrg = e.getListaOrganizadores();

                boolean bRet = false;
                for (Organizador org : lOrg) {
                    if (org.getUtilizador().equals(u)) {
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
        List<Evento> le = new ArrayList<Evento>();

        for (Evento e : m_listaEventos) {
            if (e.aceitaSubmissoes()) {
                le.add(e);
            }
        }

        return le;
    }

}
