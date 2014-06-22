package states;

import eventoscientificos.Evento;
import java.io.Serializable;

/**
 * Esta classe gere o estado de um evento validando se o mesmo reune condições
 * para passar do estado Registado a Valores de Registo Definidos.
 *
 * @author GRUPO66 LAPR2
 */
public class EventoRegistadoState implements EventoState, Serializable{
    Evento m_e;

    /**
     * Cria uma instância de EventoRegistadoState
     *
     * @param m_e
     */
    public EventoRegistadoState(Evento m_e) {
        this.m_e = m_e;
    }

         /**
     * Faz o set do estado criado ficheiro
     *
     * @return false valor booleano falso
     */
    public boolean setCriadoFicheiro() {
        return false;
    }
    
    /**
     * Faz o set do estado lido ficheiro (aprovado após confirmacao)
     *
     * @return false valor booleano falso
     */
    public boolean setLidoFicheiro() {
        return false;
    }

    /**
     * Faz o set do estado Criado.
     *
     * @return false
     */
    public boolean setCriado() {
        return false;
    }

    /**
     * Faz o set do estado Registado.
     *
     * @return false
     */
    public boolean setRegistado() {
        return false;
    }

    /**
     * Valores Registo Definidos.
     *
     * @return boolean
     */
    public boolean valida() {
        if (this.m_e.getM_registoNoEvento().getPagamentoReg() != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Faz uma validação ao estado atual e se passar na validação altera o
     * estado para Valores Registo Definidos.
     *
     * @return verdaeiro ou falso em função da validação
     */
    public boolean setValorRegistoDefinido() {
        if (valida()) {
            this.m_e.setState(new EventoValoresRegistoDefinidos(this.m_e));
            return true;
        } else {
            return false;
        }
    }

    /**
     * Faz o set do estado Tópicos Definidos.
     *
     * @return false
     */
    public boolean setTopicosDefinidos() {
        return false;
    }

    /**
     * Faz o set do estado CP Definida.
     *
     * @return false
     */
    public boolean setCPDefinida() {
        return false;
    }

    /**
     * Faz o set do estado Distribuido.
     *
     * @return false
     */
    public boolean setDistribuido() {
        return false;
    }

    /**
     * Faz o set do estado Revisto.
     *
     * @return false
     */
    public boolean setRevisto() {
        return false;
    }

    /**
     * Faz o set do estado Decidido.
     *
     * @return false
     */
    public boolean setDecidido() {
        return false;
    }

    /**
     * Faz o set do estado Notificado.
     *
     * @return false
     */
    public boolean setNotificado() {
        return false;
    }

    /**
     * Faz o set do estado Camera Ready.
     *
     * @return false
     */
    public boolean setCameraReady() {
        return false;
    }

}
