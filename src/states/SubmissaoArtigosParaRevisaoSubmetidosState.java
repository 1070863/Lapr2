package states;

import eventoscientificos.Submissao;
import java.io.Serializable;

/**
 * ArtigosParaRevisaoSubmetidosState gere o estado de uma submissão, efetudando
 * validações e de acordo com o modelo de negócio .
 *
 * @author GRUPO66 LAPR2
 */
public class SubmissaoArtigosParaRevisaoSubmetidosState implements SubmissaoState, Serializable {

    Submissao m_submissao;

    /**
     * Construtor da classe Submissão quando Submissão é passado por parâmetro.
     *
     * @param m_submissao objeto do tipo Submissão
     */
    public SubmissaoArtigosParaRevisaoSubmetidosState(Submissao m_submissao) {
        this.m_submissao = m_submissao;
    }

    /**
     * Define a submissão como criada quando iniciado o processo de Submissão.
     *
     * @return false
     */
    public boolean SetCriada() {
        return false;

    }

    /**
     * Define a submissão como submetida e pronta para revisão após o sucesso do
     * processo de Submissão.
     *
     * @return false
     */
    public boolean SetArtigosParaRevisaoSubmetidos() {
        return false;
    }

    /**
     * Define a submissão como distribuida após ter sido distribuida para
     * revisão.
     *
     * @return false
     */
    public boolean setDestribuida() {

        if (valida()) {
            m_submissao.setState(new SubmissaoDistribuidaState(m_submissao));
            return true;
        } else {
            return false;
        }
    }

    /**
     * Efetua a validação do estado em que se encontra a Submissão.
     *
     * @return verdadeiro ou falso em função da sua validação
     */
    public boolean valida() {
        return true;

    }

    /**
     * Define a submissão como revista após ter sido submetida a sua revisão.
     *
     * @return false
     */
    public boolean setRevista() {
        return false;
    }

    /**
     * Define a submissão como registada após o pagamento do Registo no Evento.
     *
     * @return false
     */
    public boolean setRejeitada() {
        return false;
    }

    /**
     * Define a submissão como aceite após o parecer positivo do Organizador.
     *
     * @return false
     */
    public boolean setAceite() {
        return false;
    }

    /**
     * Define a submissão como NotificadaAceite após a aceitação do artigo no
     * Evento e a geração da notificação.
     *
     * @return false
     */
    public boolean setNotificadoAceite() {
        return false;
    }

    /**
     * Define a submissão como registada após o pagamento do Registo no Evento.
     *
     * @return false
     */
    public boolean setRegistada() {
        return false;
    }

}
