package states;

import eventoscientificos.Evento;

/**
 * Esta classe gere o estado de um evento validando se o mesmo reune condições
 * para passar do estado Valores de Registo Definidos a Tópicos Definidos.
 *
 * @author GRUPO66 LAPR2
 */
public class EventoValoresRegistoDefinidos implements EventoState {
    Evento m_e;

    /**
     * Cria uma instância de EventoValoresRegistoDefinidos.
     *
     * @param m_e
     */
    public EventoValoresRegistoDefinidos(Evento m_e) {
        this.m_e = m_e;
    }

    /**
     * Faz o set do estado criado.
     *
     * @return false
     */
    public boolean setCriado() {
        return false;
    }

    /**
     * Faz o set do estado registado.
     *
     * @return false
     */
    public boolean setRegistado() {
        return false;
    }

    /**
     * Valida se o estado tópicos definidos.
     *
     * @return verdadeiro se validado e falso caso contrário
     */
    public boolean valida() {
        if (m_e.getM_listaTopicos().size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Valida se o evento reune condições para passar para o estado tópicos
     * definidos.
     *
     * @return verdadeiro se passar a validação e falso no caso contrário
     */
    @Override
    public boolean setValorRegistoDefinido() {
        if (valida()) {
            m_e.setState(new EventoTopicosDefinidosState(m_e));
            return true;
        } else {
            return false;
        }
    }

    /**
     * Faz o set do estado tópicos definidos.
     *
     * @return false
     */
    @Override
    public boolean setTopicosDefinidos() {
        return false;
    }

    /**
     * Faz o set do estado CP Definida.
     *
     * @return false
     */
    @Override
    public boolean setCPDefinida() {
        return false;
    }

    /**
     * Faz o set do estado Distribuido.
     *
     * @return false
     */
    @Override
    public boolean setDistribuido() {
        return false;
    }

    /**
     * Faz o set do estado Revisto.
     *
     * @return false
     */
    @Override
    public boolean setRevisto() {
        return false;
    }

    /**
     * Faz o set do estado Decidido.
     *
     * @return false
     */
    @Override
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
