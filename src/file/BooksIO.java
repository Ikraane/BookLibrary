package file;

import BooksUtil.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * Denna klass hanterar serialisering
 */

//Källa: Anders Lindstöms lektion

public class BooksIO {

    public BooksIO() {

    }

    /**
     * Denna metod används när programmet stängs och sparar i filen
     * @param filename
     * @param books
     */
   public static void serializeToFile(String filename, List<Book> books){
       FileOutputStream fout = null;

       try {
           fout = new FileOutputStream(filename);
           ObjectOutputStream ous = new ObjectOutputStream(fout);
           ous.writeObject(books);
           System.out.println("Serializing successfully completed");
       }
       catch (IOException e){
           System.out.println(e);
       }
       finally {
           try {
               if (fout != null) fout.close();
           } catch (IOException e) {
           }
       }
   }

    /**
     * Denna metod öppnar en fil och läser in dess innehåll
     * @param filename
     * @return
     * @throws ClassNotFoundException
     * @throws IOException
     */
   @SuppressWarnings("Unchecked")
   public static List<Book> deserializeFromFile(String filename) throws ClassNotFoundException, IOException{
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(filename));
            List<Book> books = (List<Book>) in.readObject();
            System.out.println("Deserialize completed");
            return books;
        }finally {
            try {
                if (in != null){
                    in.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
   }
}