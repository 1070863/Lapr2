/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package states;

/**
 *
 * @author Pereira
 */
public interface SubmissaoState {
    
    
     public abstract boolean SetCriada();
    public abstract boolean SetArtigosParaRevisaoSubmetidos();
    public abstract boolean setDestribuida();
    public abstract boolean setRevista();
    public abstract boolean setRejeitada();
    public abstract boolean setAceite();
    public abstract boolean setNotificadoAceite();
    public abstract boolean valida();
    
}
