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
public class EventoDistribuidoState implements EventoState, Serializable {
    Evento m_e;

    /**
     * Cria uma instância de EventoDistribuidoState
     *
     * @param m_e
     */
    public EventoDistribuidoState(Evento m_e) {
        this.m_e = m_e;
    }

         /**
     * Faz o set do estado criado ficheiro
     *
     * @return false valor booleano falso
     */
    public boolean setCriadoFicheiro() {
        return false;
    }
    
    /**
     * Faz o set do estado lido ficheiro (aprovado após confirmacao)
     *
     * @return false valor booleano falso
     */
    public boolean setLidoFicheiro() {
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
     * Valida
     *
     * @return false
     */
    public boolean valida() {
        return true;
    }

    /**
     * Faz o set do estado tópicos dfinidos
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
     * Faz o set do estado camera ready
     *
     * @return false
     */
    public boolean setCameraReady() {
        return false;
    }

    /**
     * Faz o set do estado Valor Registo Definidos.
     *
     * @return false
     */
    @Override
    public boolean setValorRegistoDefinido() {
        return false;
    }
}
