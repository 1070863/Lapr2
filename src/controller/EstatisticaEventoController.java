
package controller;

import eventoscientificos.Distribuicao;
import eventoscientificos.Empresa;
import eventoscientificos.Evento;
import eventoscientificos.Revisor;
import eventoscientificos.Submissao;
import java.util.ArrayList;
import java.util.List;
import states.EventoCPDefinidaState;
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
                    || e.getState() instanceof EventoNotificadoState
                    || e.getState() instanceof EventoCPDefinidaState) { //Apagar este estado, exclusivo para testes
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
        String resultado = "Evento sem submissões";
        double taxa = 0;
        
        if(e.getListaSubmissoes().size() > 0)
        {
            for (Submissao s : e.getListaSubmissoes()) {
                if(s.getState() instanceof SubmissaoAceiteState)
                    contador++;
            }
            taxa = contador / e.getListaSubmissoes().size() * 100;
            resultado = String.format("%.2f", taxa);
            resultado += " %";
        }
        return resultado;
    }
    
    
    /**
     * @return lista de eventos registados com estado "Decidido" ou "Notificado"
     */
    public String getValorMedioAvaliacao(Evento e, String parametro) {
        int contador = 0;
        String resultado = "Sem dados para apresentar";
        double taxa = 0; 
        double totalDistribuicoes = e.getProcessoDistribuicao().getM_listaDistribuicao().size();
        
        if(totalDistribuicoes > 0)
        {
            for (Distribuicao d : e.getProcessoDistribuicao().getM_listaDistribuicao()) {
                switch (parametro)
                {
                    case "Confianca":
                        taxa += Integer.parseInt(d.getConfianca());
                        break;
                    case "Adequacao":
                        taxa += Integer.parseInt(d.getAdequacao());
                        break;
                    case "Originalidade":
                        taxa += Integer.parseInt(d.getOriginalidade());
                        break;
                    case "Qualidade":
                        taxa += Integer.parseInt(d.getQualidade());
                        break;
                }
            }
            taxa /= totalDistribuicoes;
            /*taxa = 0.5;
            resultado = String.format("%.2f", taxa);
            resultado += " %";*/
        }
       
        
        return resultado;
    }
}
