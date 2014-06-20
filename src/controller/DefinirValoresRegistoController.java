package controller;

import eventoscientificos.Empresa;
import eventoscientificos.Evento;
import eventoscientificos.ValorRegistoNoEvento;
import java.util.List;

/**
 * Classe
 *
 * @author GRUPO66 LAPR2
 */
public class DefinirValoresRegistoController {

    private Empresa m_empresa;
    private Evento m_evento;
    private ValorRegistoNoEvento m_valorRegisto;

    public DefinirValoresRegistoController(Empresa m_empresa) {
        this.m_empresa = m_empresa;
    }

    public DefinirValoresRegistoController() {
        this.m_empresa = null;
    }

    /**
     * Procura os eventos do organizador em função do seu id.
     *
     * @param strId endereço de email ou username do organizador
     * @return lista de eventos do organizador
     */
    public List<Evento> getEventosOrganizador(String strId) {
        return this.m_empresa.getM_registoEventos().getEventosOrganizador(strId);
    }

    /**
     * Seleciona o evento passado por parâmetro e cria um ValorRegistoNoEvento
     * nesse mesmo evento.
     *
     * @param e evento a ser selecionado
     */
    public void selectEvento(Evento e) {
        this.m_evento = e;
        this.m_valorRegisto = this.m_evento.definirValorRegisto();
    }

    public void defineValorFP(double fullPaper) {
        this.m_evento.getM_registoNoEvento().setPriceFP(fullPaper);
    }

    public void defineValorSP(double shortPaper) {
        this.m_evento.getM_registoNoEvento().setPriceSP(shortPaper);
    }

    public void defineValorPP(double posterPaper) {
        this.m_evento.getM_registoNoEvento().setPricePP(posterPaper);
    }

    public void defineFormula1() {
        this.m_evento.getM_registoNoEvento().setPagamentoRegFormual1(this.m_evento);
    }

    public void defineFormula2() {
        this.m_evento.getM_registoNoEvento().setPagamentoRegFormual2(this.m_evento);
    }

    /**
     * Quando terminado o caso de uso este método irá iniciar a validação do
     * evento.
     *
     * @return verdadeiro ou falso em função da validação do evento e dos seus
     * estados.
     */
    public boolean termina() {
//        return this.m_evento.getState().valida();
        return true;
    }
}
