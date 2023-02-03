package file;

import BooksUtil.*;
import booklibrary.*;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static file.BooksIO.serializeToFile;

/**
 * Denna klass är ett användargränssnitt
 */
public class UserInterface implements Serializable {

    private Scanner scanner;
    private CollectionOfBooks collectionOfBooks;
    public UserInterface(){
        this.scanner = new Scanner(System.in);
        this.collectionOfBooks = new CollectionOfBooks();
    }

    /**
     * Denna metod skapar en meny för användaren
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void menu() throws IOException, ClassNotFoundException {
        int choice;
        System.out.println("Enter file name");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.next();
        open(fileName);
        System.out.println(collectionOfBooks.getBooks());
        do {
            System.out.println("(1) Add book,(2) Remove book,(3) Search for book (4) List of books (5) Quit \n");
            choice=scanner.nextInt();
            switch (choice)
            {
                case 1: userAddBook();
                    break;
                case 2: removeBook();
                    break;
                case 3:search();
                    break;
                case 4: listOfBooks();
                    break;
                case 5:
                    BooksIO.serializeToFile(fileName, collectionOfBooks.getBooks());
                    break;
            }
        }while (choice != 5);

    }

    /**
     * Denna metod är till för öppning av filhantering
     * @param filename namnet på filen man vill starta
     */
    public void open(String filename){
        try {
            collectionOfBooks.addBooks(BooksIO.deserializeFromFile(filename));

        }
        catch (IOException e){
            File newFile = new File(filename);
        }
        catch (ClassNotFoundException e){
            System.out.println("File not found");
        }
    }

    /**
     * Denna metod är för att användaren ska kunna skapa en bok
     */
    public void userAddBook(){
        String title = null;
        String a = null;
        int year;
        String isbn = null;
        String genre = null;
        int rating;

        Scanner scanTitle = new Scanner(System.in);
        Scanner scanA = new Scanner(System.in);
        Scanner scanYear = new Scanner(System.in);
        Scanner scanIsbn = new Scanner(System.in);
        Scanner scanGenre = new Scanner(System.in);
        Scanner scanRating = new Scanner(System.in);

        System.out.println("Please enter title: \n");
        title = scanTitle.nextLine();
        System.out.println("Please enter authors name: \n");
        a = scanA.nextLine();
        System.out.println("Please enter authors birth year: \n");
        year = scanYear.nextInt();
        Author author = new Author(a,LocalDate.of(year,1,1));
        System.out.println("Please enter ISBN: \n");
        isbn = scanIsbn.next();
        System.out.println("Please enter genre: \n");
        genre = scanGenre.next();
        System.out.println("Please enter rating: ");
        rating = scanRating.nextInt();
        add(title, author, isbn, genre, rating);

    }

    /**
     * Denn metod är för att addera alla parametrar och skapa ett objekt i form av Book
     * @param title
     * @param author
     * @param isbn
     * @param genre
     * @param rating
     */
    public void add(String title, Author author, String isbn, String genre, int rating){
        Book book = new Book(title, author, ISBN.createISBN(isbn), Genre.valueOf(genre), rating);
        collectionOfBooks.addBook(book);
    }

    /**
     * Dennna metod gör att användaren tar bort en bok från listan
     */
    public void removeBook(){
        System.out.println("Please enter title of the book to remove: ");
        String title;
        title = scanner.next();
        for (Book book : collectionOfBooks.getBooks()){
            if (book.getTitle().contains(title)){
                collectionOfBooks.removeBook(book);
            }
        }

    }

    /**
     * Denna metod gör det möjligt för användaren att söka en bok i listan efter titel, författare och ISBN
     */
    public void search(){
        int select;

        System.out.println("(1) Search by title, (2) Search by author, (3) Search by ISBN ");
        select = scanner.nextInt();

        switch (select){
            case 1:
                System.out.println("Enter title: ");
                String title = scanner.next();
                System.out.println(collectionOfBooks.searchForBooks(new TitleMatcher(title)));
                break;
            case 2:
                System.out.println("Enter author: ");
                String author = scanner.next();
                System.out.println(collectionOfBooks.searchForBooks(new AuthorMatcher(author)));
                break;
            case 3:
                System.out.println("Enter ISBN: ");
                String  isbn = scanner.next();
                System.out.println(collectionOfBooks.searchForBooks(new IsbnMatcher(isbn)));
                break;
        }
    }

    /**
     * Denn metod gör det möjligt för användaren att se sin lista av böcker
     */
    public void listOfBooks(){
        System.out.println(collectionOfBooks.getBooks());
    }
}