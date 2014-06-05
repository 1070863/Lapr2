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

    /**
     * Cria uma instância de EventoCriadoState
     * @param m_e 
     */
    public EventoCriadoState(Evento m_e) {
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
        if (valida()) {
            m_e.setState(new EventoRegistadoState(m_e));
            return true;
        } else {
            return false;
        }
    }

    /**
     * Valida se o evento tem todos os dados para poder ser registado
     * @return boolean
     */
    public boolean valida() {
        return !(m_e.getM_strTitulo().isEmpty() || m_e.getM_strDescricao().isEmpty()||m_e.getM_local()==null
                || m_e.getListaOrganizadores()==null);
    }

    /**
     * Faz o set do estado Topicos definidos
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
     * Faz o set do estado camera ready
     * @return false
     */
    public boolean setCameraReady() {
            return false;
    }    
}
