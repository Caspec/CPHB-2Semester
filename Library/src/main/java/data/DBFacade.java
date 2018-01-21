package data;

import domain.entity.Book;
import domain.entity.BookInfo;
import domain.entity.Borrower;
import domain.exception.BookException;
import domain.exception.BorrowerException;
import java.util.ArrayList;
import java.util.List;


public class DBFacade implements IDBFacade {
    
    BorrowerMapper cm = new BorrowerMapper();
    BookMapper bm = new BookMapper();
    
    @Override
    public Borrower getBorrower(int id) throws BorrowerException {
        return cm.getBorrower(id);
    }

    @Override
    public ArrayList<Borrower> getAllBorrowers() throws BorrowerException {
        return cm.getAllBorrowers();
    }

    @Override
    public Book getBook(int id) throws BookException
    {
        return bm.getBook(id);
    }

    @Override
    public ArrayList<Book> getAllBooks() throws BookException
    {
        return bm.getAllBooks();
    }

    @Override
    public Borrower login(String name, int SSN) throws BorrowerException
    {
        return cm.login(name, SSN);
    }

    @Override
    public ArrayList<BookInfo> getAllISBNCopy() throws BookException
    {
        return bm.getAllISBNCopy();
    }


}
