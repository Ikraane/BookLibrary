package BooksUtil;

public class IllegalIsbnException extends RuntimeException{
    public IllegalIsbnException(String ISBNStr){
        super(ISBNStr);
    }
    public IllegalIsbnException(){
        super();
    }
}
