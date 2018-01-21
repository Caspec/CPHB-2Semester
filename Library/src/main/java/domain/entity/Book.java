
package domain.entity;


public class Book
{
    private int isbn;
    private String title;
    private String author;
    private String language;
    private String publisher;

    public Book(int isbn, String title, String author, String language, String publisher)
    {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.language = language;
        this.publisher = publisher;
    }

    public Book()
    {
    }

    public int getIsbn()
    {
        return isbn;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public String getPublisher()
    {
        return publisher;
    }

    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }

    @Override
    public String toString()
    {
        return "Bog - " + "ISBN: " + isbn + ", Title: " + title + ", Forfatter: " + author + ", Sprog: " + language + ", Udgiver: " + publisher ;
    }

    
    
    
    
}
