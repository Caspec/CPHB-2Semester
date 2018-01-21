
package domain.entity;


public class BookInfo
{
    private int copyno;
    private String borrowed_from;
    private String borrowed_to;
    private boolean status;
    private String placing;
    private int ISBN;

    public BookInfo(int copyno, String borrowed_from, String borrowed_to, boolean status, String placing, int ISBN)
    {
        this.copyno = copyno;
        this.borrowed_from = borrowed_from;
        this.borrowed_to = borrowed_to;
        this.status = status;
        this.placing = placing;
        this.ISBN = ISBN;
    }

    public BookInfo()
    {
    }

    public int getCopyno()
    {
        return copyno;
    }

    public String getBorrowed_from()
    {
        return borrowed_from;
    }

    public void setBorrowed_from(String borrowed_from)
    {
        this.borrowed_from = borrowed_from;
    }

    public String getBorrowed_to()
    {
        return borrowed_to;
    }

    public void setBorrowed_to(String borrowed_to)
    {
        this.borrowed_to = borrowed_to;
    }

    public boolean isStatus()
    {
        return status;
    }

    public void setStatus(boolean status)
    {
        this.status = status;
    }

    public String getPlacing()
    {
        return placing;
    }

    public void setPlacing(String placing)
    {
        this.placing = placing;
    }

    public int getISBN()
    {
        return ISBN;
    }

    @Override
    public String toString()
    {
        return "BookInfo{" + "copyno=" + copyno + ", borrowed_from=" + borrowed_from + ", borrowed_to=" + borrowed_to + ", status=" + status + ", placing=" + placing + ", ISBN=" + ISBN + '}';
    }
    
    
    
    
}
