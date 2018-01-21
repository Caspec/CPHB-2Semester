
package domain.exception;


public class UserException extends Exception
{

    /**
     * Creates a new instance of <code>CustomerException</code> without detail
     * message.
     */
    public UserException()
    {
    }

    /**
     * Constructs an instance of <code>CustomerException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public UserException(String msg)
    {
        super(msg);
    }
}
