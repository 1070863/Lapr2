
package controller;

import eventoscientificos.Empresa;
import eventoscientificos.Evento;
import eventoscientificos.Submissao;
import java.util.ArrayList;
import java.util.List;
import states.EventoDecididoState;
import states.EventoLidoFicheiroState;
import states.EventoNotificadoState;
import states.SubmissaoAceiteState;

/**
 * Esta classe serve como controladora do fluxo entre a interface gráfica e a as
 * classes intervenientes para a apresentação de dados estatísticos do evento.
 *
 * @author Grupo 66 LPR2
 */
public class EstatisticaEventoController {
    /**
     * Atributos de intância.
     */
    private Empresa m_empresa;
    
     /**
     * Construtor responsável por criar instância de empresa.
     *
     * @param m_empresa Empresa a ser instânciada
     */
    public EstatisticaEventoController(Empresa m_empresa) {
        this.m_empresa = m_empresa;
    }
    
    /**
     * @return lista de eventos registados com estado "Decidido" ou "Notificado"
     */
    public List<Evento> getListaEventosDecididoNotificado() {
        List<Evento> eventos = new ArrayList<>();
        for (Evento e : m_empresa.getM_registoEventos().getM_listaEventos()) {
            if (e.getState() instanceof EventoDecididoState
                    || e.getState() instanceof EventoNotificadoState) {
                eventos.add(e);
            }
        }
        return eventos;
    }
    
    /**
     * @return lista de eventos registados com estado "Decidido" ou "Notificado"
     */
    public String getTaxaAceitacao(Evento e) {
        int contador = 0;
        String result = "Evento sem submissões";
        float taxa = 0;
        
        if(e.getListaSubmissoes().size() > 0)
        {
            for (Submissao s : e.getListaSubmissoes()) {
                if(s.getState() instanceof SubmissaoAceiteState)
                    contador++;
            }
            taxa = contador / e.getListaSubmissoes().size() * 100;
            result.format("%.2f",taxa);
            result += " %";
        }
        return result;
    }
}
