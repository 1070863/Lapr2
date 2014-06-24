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
public class EventoNaoEncontradoException extends Exception {

    /**
     * Creates a new instance of <code>EventoNaoEncontradoException</code>
     * without detail message.
     */
    public EventoNaoEncontradoException() {
        super("O evento não foi encontrado!");
    }

    /**
     * Constructs an instance of <code>EventoNaoEncontradoException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public EventoNaoEncontradoException(String msg) {
        super(msg);
    }
}
