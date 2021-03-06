package states;

import eventoscientificos.Evento;
import java.io.Serializable;

/**
 *
 * @author Pedro
 */
public class EventoRevistoState implements EventoState, Serializable{
    Evento m_e;

    public EventoRevistoState(Evento m_e) {
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
    
    public boolean setCriado() {
        return false;
    }

    public boolean setRegistado() {
        return false;
    }

    public boolean valida() {
        return true;
    }

    /**
     * Faz o set do estado Tópicos Definidoa.
     *
     * @return boolean
     */
    public boolean setTopicosDefinidos() {
        return false;
    }

    /**
     * Faz o set do estado CP Definida.
     *
     * @return boolean
     */
    public boolean setCPDefinida() {
        return false;
    }

    /**
     * Faz o set do estado Distribuido.
     *
     * @return boolean
     */
    public boolean setDistribuido() {
        return false;
    }

    /**
     * Faz o set do estado Revisto.
     *
     * @return boolean
     */
    public boolean setRevisto() {
        return false;
    }

    /**
     * Faz o set do estado decidido
     *
     * @return boolean
     */
    public boolean setDecidido() {
        if (valida()) {
            m_e.setState(new EventoDecididoState(m_e));
            return true;
        } else {
            return false;
        }
    }

    /**
     * Faz o set do estado Notificado.
     *
     * @return boolean
     */
    public boolean setNotificado() {
        return false;
    }

    /**
     * Faz o set do estado Camera Ready.
     *
     * @return boolean
     */
    public boolean setCameraReady() {
        return false;
    }

    /**
     * Faz o set do estado Valor registo Definido.
     *
     * @return boolean
     */
    @Override
    public boolean setValorRegistoDefinido() {
        return false;
    }

}
