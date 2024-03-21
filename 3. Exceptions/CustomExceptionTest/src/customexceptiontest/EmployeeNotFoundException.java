package customexceptiontest;

/**
 *
 * @author Diego Casignia
 */

public class EmployeeNotFoundException extends Exception{
    public EmployeeNotFoundException(String message){
        super(message);
    }

    public EmployeeNotFoundException(Throwable cause){
        super(cause);
    }

    public EmployeeNotFoundException(String message,Throwable cause){
        super(message,cause);
    }
}
