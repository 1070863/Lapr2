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
public class EventoDecididoState implements EventoState {

    Evento m_e;

    /**
     * Cria uma instância de EventoDecididoState
     *
     * @param m_e
     */
    public EventoDecididoState(Evento m_e) {
        this.m_e = m_e;
    }

    /**
     * Faz o set do estado criado
     *
     * @return false
     */
    public boolean setCriado() {
        return false;
    }

    /**
     * Faz o set do estado registado
     *
     * @return false
     */
    public boolean setRegistado() {
        return false;
    }

    /**
     * Valida se o evento tem todas as condições para passar para o estado
     * notificado
     *
     * @return boolean
     */
    public boolean valida() {
        // validação específica do estado CP Definida
        return true;
    }

    /**
     * Faz o set do estado topicos definidos
     *
     * @return false
     */
    public boolean setTopicosDefinidos() {
        return false;
    }

    /**
     * Faz o set do estado CD definida
     *
     * @return false
     */
    public boolean setCPDefinida() {
        return false;
    }

    /**
     * Faz o set do estado distribuido
     *
     * @return false
     */
    public boolean setDistribuido() {
        return false;
    }

    /**
     * Faz o set do estado revisto
     *
     * @return false
     */
    public boolean setRevisto() {
        return false;
    }

    /**
     * Faz o set do estado decidido
     *
     * @return false
     */
    public boolean setDecidido() {
        return false;
    }

    /**
     * Faz o set do estado notificado
     *
     * @return boolean
     */
    public boolean setNotificado() {
        if (valida()) {
            m_e.setState(new EventoNotificadoState(m_e));
            return true;
        } else {
            return false;
        }
    }

    /**
     * Faz o set do estado camera ready
     *
     * @return false
     */
    public boolean setCameraReady() {
        return false;
    }

    /**
     * Faz o set do estado Valor registo Definidos.
     *
     * @return false
     */
    @Override
    public boolean setValorRegistoDefinido() {
        return false;
    }

}
