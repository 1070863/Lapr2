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
public interface EventoState {
    public abstract boolean SetCriado();
    public abstract boolean SetRegistado();
    public abstract boolean setTopicosDefinidos();
    public abstract boolean setCPDefinida();
    public abstract boolean setDistribuido();
    public abstract boolean setRevisto();
    public abstract boolean setDecidido();
    public abstract boolean setNotificado();
    public abstract boolean setCameraReady();
    public abstract boolean valida();
}
