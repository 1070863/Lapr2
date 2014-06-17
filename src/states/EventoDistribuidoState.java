/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package states;

import eventoscientificos.Evento;

/**
 *
 * @author Pedro
 */
public class EventoDistribuidoState implements EventoState {
    Evento m_e;

    /**
     * Cria uma instância de EventoDistribuidoState
     * @param m_e 
     */
    public EventoDistribuidoState(Evento m_e) {
        this.m_e = m_e;
    }
    
    /**
     * Faz o set do estado criado 
     * @return false
     */
    public boolean SetCriado() {
        return false;
    }

    /**
     * Faz o set do estado registado
     * @return false
     */
    public boolean SetRegistado() {
        return false;
    }

    /**
     * Faz o set do estado valida
     * @return false
     */
    public boolean valida() {
        // validação específica do estado CP Definida
        return true;
    }

    /**
     * Faz o set do estado tópicos dfinidos
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
     * @return false
     */
    public boolean setDistribuido() {
               return false;
    }

    /**
     * Faz o set do estado revisto
     * @return boolean
     */
    public boolean setRevisto() {
         if (valida()) {
            m_e.setState(new EventoRevistoState(m_e));
            return true;
        } else {
            return false;
        }
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
     * Faz o set do estado camera ready
     * @return false
     */
    public boolean setCameraReady() {
        return false;
    }
}
