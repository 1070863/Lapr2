/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eventoscientificos;

/**
 *
 * @author Pedro
 */
public class EventoNotificadoState implements EventoState{
    Evento m_e;

    public EventoNotificadoState(Evento m_e) {
        this.m_e = m_e;
    }
    
    public boolean SetCriado() {
        return false;
    }

    public boolean SetRegistado() {
        return false;
    }

    public boolean valida() {
        // validação específica do estado CP Definida
        return true;
    }

    public boolean setTopicosDefinidos() {
     return false;
    }

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

    public boolean setCameraReady() {
if (valida()) {
            m_e.setState(new EventoCameraReadyState(m_e));
            return true;
        } else {
            return false;
        }
    }

}
