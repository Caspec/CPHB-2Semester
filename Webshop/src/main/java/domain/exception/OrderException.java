
package domain.exception;


public class OrderException extends Exception
{

    /**
     * Creates a new instance of <code>OrderException</code> without detail
     * message.
     */
    public OrderException()
    {
    }

    /**
     * Constructs an instance of <code>OrderException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public OrderException(String msg)
    {
        super(msg);
    }
}
