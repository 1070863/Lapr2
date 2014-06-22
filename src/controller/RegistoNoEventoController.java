package controller;

import eventoscientificos.Empresa;
import eventoscientificos.Evento;
import eventoscientificos.RegistoNoEvento;
import eventoscientificos.Submissao;
import java.util.List;

/**
 * esta classe serve de controladora do fluxo de infomração entreo o sistema e a
 * janla de interface gráfica.
 *
 * @author GRUPO66 LAPR2
 */
public class RegistoNoEventoController {

    Empresa m_empresa;
    Evento m_evento;
    RegistoNoEvento m_registonoEvento;

    /**
     * Construto completo quando passado o atributo empresa por parâmetro.
     *
     * @param m_empresa objeto do tipo empresa
     */
    public RegistoNoEventoController(Empresa m_empresa) {
        this.m_empresa = m_empresa;
    }

    /**
     * Efetua uma busca no registo de eventos por eventos onde tenha sido
     * indicado como correpondente .
     *
     * @param strId id do autor correspondente
     * @return lista de eventos do Autor Aceites
     */
    public List<Evento> getEventosAutorSubAceites(String strId) {
        return this.m_empresa.getM_registoEventos().getEventosAutorAceites(strId);
    }

    /**
     * Seleciona o evento passado por parâmetro e cria um objeto do tipo
     * RegistoNoEvento nesse mesmo evento.
     *
     * @param e evento a ser selecionado
     */
    public void selectEvento(Evento e) {
        this.m_evento = e;
        this.m_registonoEvento = this.m_evento.novoRegisto();
    }

    /**
     * Procura na lista de Submisões as submissões do Autor, separa por tipo de
     * artigo e calcula o valor a pagar em função dos valores de registo
     * definidos para o Evento.
     *
     * @param id identificação do Autor
     * @return valor a pagar pelo Registo no Evento
     */
    public double calculaValor(String id) {
        int numSP = 0;
        int numPP = 0;
        int numFP = 0;

        for (Submissao sub : this.m_evento.getListaSubmissoes()) {
            if (sub.getArtigo().getAutorCorrespondente().getUtilizador().
                    equals(this.m_empresa.getM_registaUtilizador().getUtilizador(id))) {
                if (sub.getArtigo().getTipo().equalsIgnoreCase("Short Paper")) {
                    this.m_registonoEvento.getM_listaSubmisoesAceites().add(sub);
                    numSP++;
                } else if (sub.getArtigo().getTipo().equalsIgnoreCase("Poster Paper")) {
                    this.m_registonoEvento.getM_listaSubmisoesAceites().add(sub);
                    numPP++;
                } else {
                    this.m_registonoEvento.getM_listaSubmisoesAceites().add(sub);
                    numFP++;
                }
            }
        }
        return this.m_evento.definirValorRegisto().getPagamentoReg().calculaValor(numFP, numPP, numSP);
    }

    /**
     * Adiciona registo ao evento.
     *
     * @return verdadeio se o registo for adicionado e falso no caso contrário
     */
    public boolean adicionaRegisto() {
        return this.m_evento.addRegistoNoEvento(this.m_registonoEvento);
    }

}
