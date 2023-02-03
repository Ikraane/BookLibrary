package booklibrary;

import BooksUtil.Book;

import java.io.Serializable;
import java.util.*;

/** I denna klass skapas en kollektion av böcker
 *
 */

//Källa: Anders Lindstöms lektion

public class CollectionOfBooks{

    private List<Book> books;
    private String searchWord;
    private BookMatcher bookMatcher;

    public CollectionOfBooks(){
        books = new ArrayList<>();
    }

    /** Denna metod adderar alla böcker till en lista
     *
     * @param allBooks är alla böcker
     */
    public void addBooks(List<Book> allBooks){
        this.books = allBooks;
    }

    /** Denna metod adderar en bok och dess författare till listan av böcker
     *
     * @param book är boken som ska adderas
     * @throws IllegalStateException
     */
    public void addBook(Book book)throws IllegalStateException{
        if(book == null) throw new IllegalStateException("Can not add\n");
        {
            books.add(book);
            book.addAuthor(book.getAuthor());
        }
    }

    /**
     *  Denna metod tar bort en bok från listan
     * @param book är boken som ska tas bort
     */
    public void removeBook(Book book){
        if (book == null) throw new IllegalStateException("Can not remove\n");
        {
            books.remove(book);
        }
        System.out.println(books);
    }

    /**
     * Denna metod hämtar en kopia av böckerna i listan
     * @return kopia av böckerna i listform
     */
    public List<Book> getBooks(){
        List<Book> copyOfBooks = new ArrayList<Book>();
        copyOfBooks.addAll(books);
        return copyOfBooks;
    }

    /**
     * Denna metod söker efter böcker i listan av böcker
     * @param matcher
     * @return en temporär lista av hittade böcker
     */
    public List<Book> searchForBooks(BookMatcher matcher){

        List<Book> tmp = new ArrayList<>();
        for (Book book : books){
            if (matcher.matches(book)){
                tmp.add(book);
            }
        }
        Collections.sort(tmp);
        return tmp;
    }

    @Override
    public String toString(){
        String result = "\n" + books;
        return result;
        /*
        return "CollectionOfBooks{" +
                "books=" + books +
                '}';*/
    }

}