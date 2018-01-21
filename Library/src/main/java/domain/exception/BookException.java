
package domain.exception;


public class BookException extends Exception
{

    /**
     * Creates a new instance of <code>OrderException</code> without detail
     * message.
     */
    public BookException()
    {
    }

    /**
     * Constructs an instance of <code>OrderException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public BookException(String msg)
    {
        super(msg);
    }
}
