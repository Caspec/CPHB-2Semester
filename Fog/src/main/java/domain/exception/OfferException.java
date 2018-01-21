/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.exception;

/**
 *
 * @author Makemewant
 */
public class OfferException extends Exception {

    /**
     * Creates a new instance of <code>TilbudException</code> without detail
     * message.
     */
    public OfferException() {
    }

    /**
     * Constructs an instance of <code>TilbudException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public OfferException(String msg) {
        super(msg);
    }
}
