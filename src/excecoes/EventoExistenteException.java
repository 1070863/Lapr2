/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package excecoes;

import java.io.Serializable;

/**
 *
 * @author Pedro
 */
public class EventoExistenteException extends Exception implements Serializable {
    private static final long serialVersionUID = 1L;
            
    /**
     * Creates a new instance of <code>EventoExistenteException</code> without
     * detail message.
     */
    public EventoExistenteException() {
        super("Evento já existe!");
    }

    /**
     * Constructs an instance of <code>EventoExistenteException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public EventoExistenteException(String msg) {
        super(msg);
    }
}
