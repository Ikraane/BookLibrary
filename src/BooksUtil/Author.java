package BooksUtil;

import java.io.Serializable;
import java.time.LocalDate;

/**Denna klass skapar ett författarobjekt
 *
 */
public class Author implements Serializable {
    private String name;
    private LocalDate dateOfBirth;

    public Author(String name, LocalDate dateOfBirth){
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    /** Denna metod hämtar namn på författare
     *
     * @param n är en inskickad string
     * @return namnet på författaren
     */

    public String getName(String n){
        return name;
    }

    /** Denna metod hämtar födelsedatum
     *
     * @return födelsedatum
     */

    public LocalDate getDateOfBirth(){
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return name+" " + dateOfBirth;
    }
}
