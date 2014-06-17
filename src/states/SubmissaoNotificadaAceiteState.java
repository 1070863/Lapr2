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
public class SubmissaoNotificadaAceiteState implements SubmissaoState {
    
    Submissao m_submissao;

    public SubmissaoNotificadaAceiteState(Submissao m_submissao) {
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean setRejeitada() {
        return false;
    }

    @Override
    public boolean setAceite() {
        return false;
    }
    public boolean setNotificadoAceite() {
        return false;
    }

    @Override
    public boolean valida() {
        return true;
    }
    
    
}
