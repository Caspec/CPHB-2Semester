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
public class CupCakeException extends Exception
{

    /**
     * Creates a new instance of <code>CupCakeException</code> without detail
     * message.
     */
    public CupCakeException()
    {
    }

    /**
     * Constructs an instance of <code>CupCakeException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CupCakeException(String msg)
    {
        super(msg);
    }
}
