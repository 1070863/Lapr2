package controller;

import eventoscientificos.CP;
import eventoscientificos.Empresa;
import eventoscientificos.Evento;
import eventoscientificos.Revisor;
import eventoscientificos.Topico;
import eventoscientificos.Utilizador;
import java.util.List;

/**
 * Esta classe serve como controladora do fluxo entre a interface gráfica e a as
 * classes intervenientes para a criação de uma CP(Comissão de Programa).
 *
 * @author Grupo 66 LPR2
 */
public class CriarCPController {

    /**
     * Atributos de intância.
     */
    private Empresa m_empresa;
    private Evento m_evento;
    private CP m_cp;

    /**
     * Construtor responsável por criar instância de empresa.
     *
     * @param empresa Empresa a ser intâncida
     */
    public CriarCPController(Empresa empresa) {
        this.m_empresa = empresa;
    }

    /**
     * Procuara os eventos do organizador em função do seu id.
     *
     * @param strId endereço de email ou username do organizador
     * @return lista de eventos do organizador
     */
    public List<Evento> getEventosOrganizador(String strId) {
        return this.m_empresa.getM_registoEventos().getEventosOrganizador(strId);
    }

    /**
     * Procura os tópicos do evento instânciado.
     *
     * @return lista de tópicos do evento
     */
    public List<Topico> getTopicosEvento() {
        if (this.m_evento != null) {
            return this.m_evento.getTopicos();
        } else {
            return null;
        }
    }

    /**
     * Seleciona o evento passado por parâmetro e cria um CP (Comissão de
     * Programa) nesse mesmo evento.
     *
     * @param e evento a ser selecionado
     */
    public void selectEvento(Evento e) {
        this.m_evento = e;

        this.m_cp = this.m_evento.novaCP();
    }

    /**
     * Adiciona membro Revisor a CP (Comissão de Programa) em função do seu id.
     *
     * @param strId endereço de email ou username do organizador
     * @return objeto do tipo revisor
     */
    public Revisor addMembroCP(String strId) {
        Utilizador u = this.m_empresa.getM_registaUtilizador().getUtilizador(strId);

        if (u != null) {
            return this.m_cp.addMembroCP(strId, u);
        } else {
            return null;
        }
    }

    /**
     * Regista na lista de membros da CP (Comissão de Programa) o Revisor
     * passado por parâmetro.
     *
     * @param r objeto do tipo Revisor
     * @return verdadeiro/falso em função do registo verificado
     */
    public boolean registaMembroCP(Revisor r) {
        return this.m_cp.registaMembroCP(r);
    }

    /**
     * Atribui a CP (Comissão de Programa) ao evento.
     */
    public void setCP() {
        this.m_evento.setCP(this.m_cp);
    }

    /**
     * Atribui lista de tópicos de perícia a Revisor da CP (Comissão de
     * Programa).
     *
     * @param r objeto revisor da CP (Comissão de Programa)
     * @param listaTopicosRevisor lista de tópicos de perícia
     */
    public void setListaTopicosRevisor(Revisor r, List<Topico> listaTopicosRevisor) {
        if (this.m_cp.getListaRevisores().contains(r)) {
            r.setListaTopicos(listaTopicosRevisor);
        }
    }
}
