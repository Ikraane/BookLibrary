import BooksUtil.*;
import booklibrary.*;
import file.BooksIO;
import file.UserInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        UserInterface userInterface = new UserInterface();
        userInterface.menu();


/*
        String name = "jk";
       // String name2 = "Harry";
        //String name3 = "Najiib";
        String searchWord;
       // Scanner scanner = new Scanner(System.in);
        //CollectionOfBooks collectionOfBooks = new CollectionOfBooks();
        Author jk = new Author(name, LocalDate.of(1955,07,14));
       // Author Harry = new Author(name2, LocalDate.of(1970,10,27));
        //Author Najib = new Author(name3, LocalDate.of(1966,2,4));
        String number = "1234567891011";
        Book book = new Book("Haarry Potter",jk, ISBN.createISBN(number), Genre.FICTION, 3);
        //Book book2 = new Book("Hanger games",Najib, ISBN.createISBN(number), Genre.BIOGRAPHY, 4);
       // book.addAuthor(Harry);
        book.addAuthor(jk);
        System.out.println("\n" + book);
        collectionOfBooks.addBook(book);
        /*System.out.println(book.getAuthors());
        System.out.println(book.getISBN());
        System.out.println(book.getGenre());
        System.out.println(book.getRating());
        System.out.println(book.getTitle());
        System.out.println(book.compareTo(book));
        collectionOfBooks.addBook(book);
        //collectionOfBooks.addBook(book2);
        System.out.println(collectionOfBooks);
        //collectionOfBooks.removeBook(book2);
        /*System.out.println(collectionOfBooks);
        System.out.println("Enter searchword: \n");
        searchWord = scanner.next();
        collectionOfBooks.searchForBooks(new AuthorMatcher(searchWord));*/



    }
}
