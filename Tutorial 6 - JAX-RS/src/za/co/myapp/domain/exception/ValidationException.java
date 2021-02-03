package za.co.myapp.domain.exception;

import java.util.ArrayList;
import java.util.List;


public class ValidationException extends Exception {
    
    List<String> errors = new ArrayList<>();   

    public void addError(String error) {
        errors.add(error);
    }   
    
    public boolean hasErrors() {
        return errors.size() > 0;
    }
    
    public String getMessage() {
        return "Validation error: " + String.join(",", errors) + ".";
    }
    
    
}
