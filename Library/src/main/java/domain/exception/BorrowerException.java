
package domain.exception;


public class BorrowerException extends Exception
{

    /**
     * Creates a new instance of <code>CustomerException</code> without detail
     * message.
     */
    public BorrowerException()
    {
    }

    /**
     * Constructs an instance of <code>CustomerException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public BorrowerException(String msg)
    {
        super(msg);
    }
}
