package data;

import domain.entity.Book;
import domain.entity.BookInfo;
import domain.exception.BookException;
import domain.exception.BorrowerException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookMapper
{

    public Book getBook(int id) throws BookException
    {
        Book book = null;
        try
        {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM book WHERE book_ISBN = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next())
            {
                int book_ISBN = rs.getInt("book_ISBN");
                String book_title = rs.getString("book_title");
                String book_author = rs.getString("book_author");
                String book_language = rs.getString("book_language");
                String book_publisher = rs.getString("book_publisher");

                book = new Book(book_ISBN, book_title, book_author, book_language, book_publisher);
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace();
            throw new BookException("Error in getBook() " + ex.getMessage());
        }

        return book;
    }

    public ArrayList<Book> getAllBooks() throws BookException
    {
        Book book = null;
        ArrayList<Book> al = new ArrayList<>();
        try
        {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM book";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
            {
                int book_ISBN = rs.getInt("book_ISBN");
                String book_title = rs.getString("book_title");
                String book_author = rs.getString("book_author");
                String book_language = rs.getString("book_language");
                String book_publisher = rs.getString("book_publisher");

                book = new Book(book_ISBN, book_title, book_author, book_language, book_publisher);
                al.add(book);
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace();
            throw new BookException("Error in getAllBooks() " + ex.getMessage());
        }

        return al;
    }

    public void reserveBook(String date_from, String date_to, int copyno, int ssn) throws BookException, BorrowerException
    {
        BorrowerMapper borrower = new BorrowerMapper();
        if (borrower.getBorrower(ssn).isStatus() == true)
        {
            Connection conn = new DB().getConnection();
            try
            {
                //Starter transaktion
                String ins_bookreserve = "INSERT INTO book_reserve (book_reserve_from, book_reserve_to, fk_book_info_copyno, fk_borrower_ssn) VALUES (?, ?, ?, ?)";
                PreparedStatement bookreserveStmt = conn.prepareStatement(ins_bookreserve);

                //Transaction
                conn.setAutoCommit(false);
                //Book reserve
                bookreserveStmt.setString(1, date_from);
                bookreserveStmt.setString(2, date_to);
                bookreserveStmt.setInt(3, copyno);
                bookreserveStmt.setInt(4, ssn);
                bookreserveStmt.executeUpdate();

                conn.commit();
            } catch (SQLException ex)
            {
                ex.printStackTrace();
                try
                {
                    conn.rollback();
                } catch (SQLException ex1)
                {
                    ex1.printStackTrace();
                    throw new BookException("Error in reserveBook() " + ex1.getMessage());
                }
            }
        } else if (borrower.getBorrower(ssn).isStatus() == false)
        {
            System.out.println("Du har ikke status på 1!!!!");
        }

    }
    
     public ArrayList<BookInfo> getAllISBNCopy() throws BookException
    {
        BookInfo bookinfo = null;
        ArrayList<BookInfo> al = new ArrayList<>();
        try
        {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM book_info";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
            {
                int book_info_copyno = rs.getInt("book_info_copyno");
                String book_info_borrowed_from = rs.getString("book_info_borrowed_from");
                String book_info_borrowed_to = rs.getString("book_info_borrowed_to");
                boolean book_info_status = rs.getBoolean("book_info_status");
                String book_info_placing = rs.getString("book_info_placing");
                int fk_book_info_ISBN = rs.getInt("fk_book_ISBN");

                bookinfo = new BookInfo(book_info_copyno, book_info_borrowed_from, book_info_borrowed_to, book_info_status, book_info_placing, fk_book_info_ISBN);
                al.add(bookinfo);
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace();
            throw new BookException("Error in getAllISBNCopy() " + ex.getMessage());
        }

        return al;
    }
    

    public static void main(String[] args) throws BookException
    {
        Book book = new BookMapper().getBook(545010225);
        System.out.println(book);
        ArrayList<Book> book2 = new BookMapper().getAllBooks();
        System.out.println(book2);
    }
}
