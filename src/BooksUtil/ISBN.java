package BooksUtil;

import java.io.Serializable;
import java.util.regex.Pattern;

/** Denna klass skapar ett ISBNobjekt
 *
 */

//Källa: Anders Lindstöms övningar

public class ISBN implements Serializable {
    private String ISBNStr;
    private static final String ISBNPattern = "^[0-9]{13}$";

    /** Denna metod skapar en string av ISBN
     *
     * @param ISBNStr tar in en rad siffror
     * @return siffrorna i ny string
     * @throws IllegalIsbnException
     */

    public static ISBN createISBN(String ISBNStr)throws IllegalIsbnException {
        return new ISBN(ISBNStr);
    }

    /** Denna metod hämtar ISBN stringen
     *
     * @return stringen
     */

    public String getISBNStr(){
        return ISBNStr;
    }

    @Override
    public String toString() {
        return "ISBNStr='" + ISBNStr + '\'';
    }

    private ISBN(String ISBNStr)throws IllegalIsbnException{
        if (!ISBNStr.matches(ISBNPattern))throw new IllegalIsbnException("Illegal isbn: " + ISBNStr);
        {
            this.ISBNStr = ISBNStr;
        }
    }
}
