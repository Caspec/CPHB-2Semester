/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.exception;

/**
 *
 * @author auron
 */
public class ItemException extends Exception {

    /**
     * Creates a new instance of <code>ItemException</code> without detail
     * message.
     */
    public ItemException() {
    }

    /**
     * Constructs an instance of <code>ItemException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public ItemException(String msg) {
        super(msg);
    }
}
