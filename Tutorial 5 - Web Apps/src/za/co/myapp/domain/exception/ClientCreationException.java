package za.co.myapp.domain.exception;


public class ClientCreationException extends Exception {
    
    public ClientCreationException(String string, Throwable throwable) {
        super(string, throwable);
    }
    
}
