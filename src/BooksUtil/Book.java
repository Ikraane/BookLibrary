package BooksUtil;

//https://beginnersbook.com/2017/08/comparable-interface-in-java-with-example/
//https://www.javatpoint.com/java-int-to-string

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import BooksUtil.*;

/**Denna klass skapar en bok
 *
 */
public class Book implements Comparable<Book>, Serializable {

    private static String s;
    private String title;
    private int rating;
    private ArrayList<Author> authors;
    private Genre genre;
    private ISBN isbn;
    private Author author;

    public Book(String title, Author author, ISBN isbn, Genre genre, int rating){
        this.title = title;
        this.rating = rating;
        this.author = author;
        this.authors = new ArrayList<>();
        this.genre = genre;
        this.isbn = isbn;
        this.s = Integer.toString(rating);

    }

    /**Denna metod adderar en författare i listan av författare
     *
     * @param author är den författare som ska adderas i listan
     */
    public void addAuthor(Author author){
        authors.add(author);
    }

    /**Denna metod hämtar en kopia av listan av författare
     *
     * @return en kopia av listan av författare
     */
    public List<Author> getAuthors(){
        return List.copyOf(authors);
    }

    /** Denna metod hämtar ISBN
     *
     * @return ISBN
     */
    public ISBN getISBN(){
        return isbn;
    }

    public Genre getGenre(){
        return genre;
    }

    /** Denna metod hämtar titel på boken
     *
     * @return titel
     */
    public String getTitle(){
        return title;
    }

    /** Denna metod hämtar författaren av en bok
     *
     * @return författaren
     */
    public Author getAuthor(){
        return author;
    }

    public int getRating(){
        return rating;
    }

    /** Denna metod jämför en titel med en titel för att senare kunna sortera. Ifall det är två likadana titlar så jämför den dess ratings och sorterar efter det
     *
     * @param book är boken som jämförs
     * @return 0 eller 1 beroende op hur den ska sortera
     */
    @Override
    public int compareTo(Book book){
        int last = this.title.compareTo(book.title);
        return last == 0 ? this.s.compareTo(Book.s) : last;
    }

    public boolean equals(Object other){
        if (other instanceof Book){
            return this.compareTo((Book)other) == 0;
        }
        return false;
    }

    @Override
    public String toString(){
        return "Book{" +
                " " + title + '\'' +
                ", " +  author +
                //", " + authors +
                ", " + genre +
                ", rating = " + rating +
                ",  " + isbn +
                '}';
    }
}