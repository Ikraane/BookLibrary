package booklibrary;

import BooksUtil.Book;
/**
 * Denna klass bekräftar om den finns en bok som matchar med ett sökord
 */

//Källa: Anders Lindstöms lektion

public class IsbnMatcher implements BookMatcher{
    private String toMatch;

    public IsbnMatcher(String toMatch){
        this.toMatch = toMatch;
    }

    @Override
    public boolean matches(Book bookToMatch) {
        return bookToMatch.getISBN().getISBNStr().contains(toMatch);
    }
}
