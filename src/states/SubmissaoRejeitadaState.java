/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package states;

import eventoscientificos.Submissao;

/**
 *
 * @author Pereira
 */
public class SubmissaoRejeitadaState implements SubmissaoState{

    Submissao m_submissao;

    public SubmissaoRejeitadaState(Submissao m_submissao) {
        this.m_submissao = m_submissao;
    }
    
    
    @Override
    public boolean SetCriada() {
        return false;
    }

    @Override
    public boolean SetArtigosParaRevisaoSubmetidos() {
       return false;
    }

    @Override
    public boolean setDestribuida() {
        return false;
    }

    @Override
    public boolean setRevista() {
        return false;
    }

    @Override
    public boolean setRejeitada() {
        return false;
    }

    @Override
    public boolean setAceite() {
        return false;
    }

    @Override
    public boolean setNotificadoAceite() {
        return false;
    }

    @Override
    public boolean valida() {
        return true;
    }
    
}