package states;

import eventoscientificos.Evento;

/**
 * Esta classe gere o estado de um evento validando se o mesmo reune condições
 * para passar do estado Tópicos Definidos a CP Definida.
 *
 * @author GRUPO66 LAPR2
 */
public class EventoTopicosDefinidosState implements EventoState {

    Evento m_e;

    /**
     * Cria uma instância de EventoCriadoState
     *
     * @param e objeto do tipo Evento
     */
    public EventoTopicosDefinidosState(Evento e) {
        m_e = e;
    }
    
    /**
     * Faz o set do estado carregado
     *
     * @return false valor booleano falso
     */
    public boolean setCarregado() {
        return false;
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
     * Faz o set do estado Registado.
     *
     * @return false
     */
    public boolean setRegistado() {
        return false;
    }

    /**
     * Valida se o evento tem todas as condições para mudar para o estado CP
     * definida
     *
     * @return false
     */
    public boolean valida() {
        if (m_e.getCP().getListaRevisores().size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Faz o set do estado Topicos Definidos.
     *
     * @return false
     */
    public boolean setTopicosDefinidos() {
        return false;
    }

    /**
     * Faz o set do estado CP definida.
     *
     * @return boolean
     */
    public boolean setCPDefinida() {
        if (valida()) {
            m_e.setState(new EventoCPDefinidaState(m_e));
            return true;
        } else {
            return false;
        }
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
     * Faz o set do estado Decidid.
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

    /**
     * Faz o set do Valor Registo Definidos.
     *
     * @return false
     */
    @Override
    public boolean setValorRegistoDefinido() {
        return false;
    }

}
