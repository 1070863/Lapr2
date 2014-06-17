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
public class EventoTopicosCriadosState implements EventoState {

    Evento m_e;

    public EventoTopicosCriadosState(Evento e) {
        m_e = e;
    }

    public boolean SetCriado() {
        return false;
    }

    public boolean SetRegistado() {
        return false;
    }

    /**
     * Valida se o evento tem todas as condições para mudar para o estado CP definida
     * @return false
     */
    public boolean valida() {
        if(m_e.getCP().getListaRevisores().size()>0)
            return true;
        else
            return false;
    }

    public boolean setTopicosDefinidos() {
     return false;
    }

    /**
     * Faz o set do estado CP definida
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

    public boolean setCameraReady() {
        return false;
    }

}
