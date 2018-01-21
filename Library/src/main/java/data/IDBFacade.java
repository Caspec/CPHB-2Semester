package data;

import domain.entity.Book;
import domain.entity.BookInfo;
import domain.entity.Borrower;
import domain.exception.BookException;
import domain.exception.BorrowerException;
import java.util.ArrayList;
import java.util.List;


public interface IDBFacade {
// Borrower
Borrower getBorrower(int id) throws BorrowerException;
ArrayList<Borrower> getAllBorrowers() throws BorrowerException;
Borrower login(String name, int SSN) throws BorrowerException;

// Book
Book getBook(int id) throws BookException;
ArrayList<Book> getAllBooks() throws BookException;
ArrayList<BookInfo> getAllISBNCopy() throws BookException;
}
