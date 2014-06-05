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
public class EventoCriadoState implements EventoState{
    Evento m_e;

    public EventoCriadoState(Evento m_e) {
        this.m_e = m_e;
    }
    
    public boolean SetCriado() {
        return false;
    }

    public boolean SetRegistado() {
        if (valida()) {
            m_e.setState(new EventoRegistadoState(m_e));
            return true;
        } else {
            return false;
        }
    }

    public boolean valida() {
        return !(m_e.getM_strTitulo().isEmpty() || m_e.getM_strDescricao().isEmpty()||m_e.getM_local()==null
                || m_e.getListaOrganizadores()==null);
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
            return false;
    }    
}
