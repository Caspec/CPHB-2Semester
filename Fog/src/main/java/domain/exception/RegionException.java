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
public class RegionException extends Exception {

    /**
     * Creates a new instance of <code>RegionException</code> without detail
     * message.
     */
    public RegionException() {
    }

    /**
     * Constructs an instance of <code>RegionException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public RegionException(String msg) {
        super(msg);
    }
}
