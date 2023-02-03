package booklibrary;

import BooksUtil.Book;

/**
 * Denna klass bekräftar om den finns en bok som matchar med ett sökord
 */

//Källa: Anders Lindstöms lektion
public class TitleMatcher implements BookMatcher{
    private String toMatch;

    public TitleMatcher(String toMatch){
        this.toMatch = toMatch;
        System.out.println(toMatch);
    }


    @Override
    public boolean matches(Book bookToMatch){
        return bookToMatch.getTitle().contains(toMatch);
    }
}
