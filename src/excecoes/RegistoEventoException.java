/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package excecoes;

/**
 *
 * @author Pedro
 */
public class RegistoEventoException extends Exception {

    /**
     * Creates a new instance of <code>RegistoEventoException</code> without
     * detail message.
     */
    public RegistoEventoException() {
        super("Evento não registado!");
    }

    /**
     * Constructs an instance of <code>RegistoEventoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public RegistoEventoException(String msg) {
        super(msg);
    }
}
