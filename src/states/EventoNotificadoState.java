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
public class EventoNotificadoState implements EventoState{
    Evento m_e;

    /**
     * Cria uma instância de EventoNotificadoState
     * @param m_e 
     */
    public EventoNotificadoState(Evento m_e) {
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
     * Valida se o evento tem todas as condições para mudar para o estado CameraReady
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

    public boolean setDistribuido() {
        return false;
    }

    public boolean setRevisto() {
        return false;
    }

    public boolean setDecidido() {
        return false;
    }

    public boolean setNotificado() {
        return false;
    }

    /**
     * Faz o set do estado CameraReady
     * @return boolean
     */
    public boolean setCameraReady() {
if (valida()) {
            m_e.setState(new EventoCameraReadyState(m_e));
            return true;
        } else {
            return false;
        }
    }

}
