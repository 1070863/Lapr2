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
public class EventoCameraReadyState implements EventoState, Serializable{
    Evento m_e;

    /**
     * Cria uma instância de EventoCamaraReadyState
     */
    public EventoCameraReadyState(Evento m_e) {
        this.m_e = m_e;
    }

    /**
     * Faz o set do estado carregado
     *
     * @return false valor booleano falso
     */
    public boolean setCarregado() {
        return false;
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
     * Valida o EventoCameraReadyState
     *
     * @return boolean
     */
    public boolean valida() {
        // validação específica do estado CP Definida
        return true;
    }

    /**
     * Faz o set do estado tópicos definidos
     *
     * @return false
     */
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
     * @return false
     */
    public boolean setNotificado() {
        return false;
    }

    /**
     * Faz o set do estado CameraReady
     *
     * @return false
     */
    public boolean setCameraReady() {
        return false;
    }

    /**
     * Faz o set do estado Valor Registo Definido.
     *
     * @return false
     */
    @Override
    public boolean setValorRegistoDefinido() {
        return false;
    }
}
