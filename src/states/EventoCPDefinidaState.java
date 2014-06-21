/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import eventoscientificos.Evento;
import java.io.Serializable;

/**
 *
 * @author Pedro
 */
public class EventoCPDefinidaState implements EventoState, Serializable {

    Evento m_e;

    /**
     * Construtor de uma instância de EventoCPDefinidaState
     *
     * @param e
     */
    public EventoCPDefinidaState(Evento e) {
        this.m_e = e;
    }

    /**
     * Faz o set do estado criado
     *
     * @return false
     */
    public boolean SetCriado() {
        return false;
    }

    /**
     * Faz o set do estado registado
     *
     * @return false
     */
    public boolean SetRegistado() {
        return false;
    }

    /**
     * Méodo para validar o EventState
     *
     * @return boolean
     */
    public boolean valida() {
        // validação específica do estado CP Definida
        return true;
    }

    /**
     * Faz o set do estado topicos definidos
     * @return false
     */
    public boolean setTopicosDefinidos() {
        return false;
    }

    /**
     * Faz o set do estado CP definida 
     * @return false
     */
    public boolean setCPDefinida() {
        return false;
    }

    /**
     * Faz o set do estado distribuido 
     * @return boolean
     */
    public boolean setDistribuido() {
        if (valida()) {
            m_e.setState(new EventoDistribuidoState(m_e));
            return true;
        } else {
            return false;
        }
    }

    /**
     * Faz o set do estado revisto 
     * @return false
     */
    public boolean setRevisto() {
        return false;
    }

    /**
     * Faz o set do estado decidido
     * @return false
     */
    public boolean setDecidido() {
        return false;
    }

    /**
     * Faz o set do estado notificado
     * @return false
     */
    public boolean setNotificado() {
        return false;
    }

    /**
     * Faz o set do estado camara ready
     * @return false
     */
    public boolean setCameraReady() {
        return false;
    }

}
