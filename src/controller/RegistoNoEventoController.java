package controller;

import eventoscientificos.Empresa;
import eventoscientificos.Evento;
import eventoscientificos.RegistoNoEvento;
import eventoscientificos.Submissao;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JTextField;

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

    /**
     * Quando terminado o caso de uso este método irá iniciar a validação do
     * evento.
     *
     * @return verdadeiro ou falso em função da validação do evento e dos seus
     * estados.
     */
    public boolean termina() {
        for (int i = 0; i < this.m_registonoEvento.getM_listaSubmisoesAceites().size(); i++) {
            this.m_registonoEvento.getM_listaSubmisoesAceites().get(i).getState().setRegistada();
        }
        return true;
    }

    /**
     * Define os valores do registo no evento de acordo com a informação passada
     * na interface gráfica.
     *
     * @param metodoPagamento método de pagamento externo
     * @param diaValidade dia da validade do cartão de crédito
     * @param mesValidade mês da validade do cartão de crédito
     * @param anoValidade ano da validade do cartão de crédito
     * @param diaLimite dia até ao qual os valores devem estar disponiveis
     * @param mesLimite mês até ao qual os valores devem estar disponiveis
     * @param anoLimite ano até ao qual os valores devem estar disponiveis
     * @param valor valor a ser autorizado
     * @param numeroCartao numero do cartão
     * @return verdadeiro ou falso em função do registo no evento
     */
    public boolean defineRegisto(String metodoPagamento, String diaValidade, String mesValidade,
            String anoValidade, String diaLimite, String mesLimite, String anoLimite, float valor, String numeroCartao) {
        if (metodoPagamento.equalsIgnoreCase("CanadaExpress")) {
            Date validade = new Date();
            validade.setDate(Integer.parseInt(diaValidade));
            validade.setMonth(Integer.parseInt(mesValidade));
            validade.setYear(Integer.parseInt(anoValidade));
            Date limite = new Date();
            limite.setDate(Integer.parseInt(diaLimite));
            limite.setMonth(Integer.parseInt(mesLimite));
            limite.setYear(Integer.parseInt(anoLimite));
            this.m_registonoEvento.pagamentoCanadaExpress(validade, numeroCartao, valor, limite);
            this.m_registonoEvento.setM_autor(this.m_registonoEvento.getM_listaSubmisoesAceites().get(1).getArtigo().getAutorCorrespondente());
            this.m_registonoEvento.setM_valor(valor);
            return adicionaRegisto();
        } else {
            String dataValidade = anoValidade + "-" + mesValidade + "-" + diaValidade;
            String dataLimite = anoLimite + "-" + mesLimite + "-" + diaLimite;
            this.m_registonoEvento.pagamentoVisaoLight(numeroCartao, dataValidade, valor, dataLimite);
            return adicionaRegisto();
        }
    }
}
