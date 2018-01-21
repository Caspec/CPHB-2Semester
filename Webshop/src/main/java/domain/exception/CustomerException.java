
package domain.exception;


public class CustomerException extends Exception
{

    /**
     * Creates a new instance of <code>CustomerException</code> without detail
     * message.
     */
    public CustomerException()
    {
    }

    /**
     * Constructs an instance of <code>CustomerException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CustomerException(String msg)
    {
        super(msg);
    }
}
