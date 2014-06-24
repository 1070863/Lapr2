package controller;

import eventoscientificos.Empresa;
import eventoscientificos.Evento;
import eventoscientificos.ValorRegistoNoEvento;
import java.util.List;

/**
 * Classe controladora do fluxo de informação entre a a classe
 * DefinirValoresRegsitoUi e o restante sistema.
 *
 * @author GRUPO66 LAPR2
 */
public class DefinirValoresRegistoController {

    /**
     * Vaiáveis de instância
     */
    private Empresa m_empresa;
    private Evento m_evento;
    private ValorRegistoNoEvento m_valorRegisto;

    /**
     * Construtor completo quando o atributo Empresa é passado por parâmetros.
     *
     * @param m_empresa
     */
    public DefinirValoresRegistoController(Empresa m_empresa) {
        this.m_empresa = m_empresa;
    }

    /**
     * Construtor por omissão do atributo Empresa.
     */
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
        return this.m_empresa.getM_registoEventos().getEventosOrgRegistados(strId);
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

    /**
     * Define o valor de registo de um Full Papper.
     */
    public void defineValorFP(double fullPaper) {
        this.m_evento.getM_registoNoEvento().setPriceFP(fullPaper);
    }

    /**
     * Define o valor de registo de um Short Papper.
     */
    public void defineValorSP(double shortPaper) {
        this.m_evento.getM_registoNoEvento().setPriceSP(shortPaper);
    }

    /**
     * Define o valor de registo de um Poster Papper.
     */
    public void defineValorPP(double posterPaper) {
        this.m_evento.getM_registoNoEvento().setPricePP(posterPaper);
    }

    /**
     * Define a fórmula de cálculo a ser usada no pagamento do registo.
     */
    public void defineFormula1() {
        this.m_evento.getM_registoNoEvento().setPagamentoRegFormual1(this.m_evento);
    }

    /**
     * Define a fórmula de cálculo a ser usada no pagamento do registo.
     */
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
        return this.m_evento.getState().setValorRegistoDefinido();
    }
}
