package booklibrary;

import BooksUtil.Author;
import BooksUtil.Book;
/**
 * Denna klass bekräftar om den finns en bok som matchar med ett sökord
 */

//Källa: Anders Lindstöms lektion

public class AuthorMatcher implements BookMatcher{
    private String toMatch;

    public AuthorMatcher(String toMatch){
        this.toMatch = toMatch;
    }

    @Override
    public boolean matches(Book bookToMatch){

        for (int i = 0; i < bookToMatch.getAuthors().size(); i++){
            return bookToMatch.getAuthors().get(i).getName(toMatch).contains(toMatch);
        }
        return false;
    }
}
