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
 * @author Lopes
 */
public class EventoCarregadoState implements EventoState, Serializable{
     Evento m_e;
     
     public EventoCarregadoState(Evento e) {
        this.m_e = e;
    }
     
      /**
     * Faz o set do estado carregado
     *
     * @return false valor booleano falso
     */
    public boolean setCarregado() {
        if (valida()) {
            m_e.setState(new EventoCarregadoState(m_e));
            return true;
        } else {
            return false;
        }
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
     * Valida se o evento tem todos os dados para poder ser registado
     *
     * @return boolean
     */
    public boolean valida() { 
        return true;
    }

    /**
     * Faz o set do estado Topicos definidos
     *
     * @return false
     */
    @Override
    public boolean setTopicosDefinidos() {
        return false;
    }

    /**
     * Faz o set do estado CP definida
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
    @Override
    public boolean setDistribuido() {
        return false;
    }

    /**
     * Faz o set do estado revisto
     *
     * @return false
     */
    @Override
    public boolean setRevisto() {
        return false;
    }

    /**
     * Faz o set do estado decidido
     *
     * @return false
     */
    @Override
    public boolean setDecidido() {
        return false;
    }

    /**
     * Faz o set do estado notificado
     *
     * @return false
     */
    @Override
    public boolean setNotificado() {
        return false;
    }

    /**
     * Faz o set do estado camera ready
     *
     * @return false
     */
    @Override
    public boolean setCameraReady() {
        return false;
    }

    /**
     * Faz o set do estado Registo Definido.
     *
     * @return
     */
    @Override
    public boolean setValorRegistoDefinido() {
        return false;
    }
}
