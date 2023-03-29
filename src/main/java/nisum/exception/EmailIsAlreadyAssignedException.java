package nisum.exception;

public class EmailIsAlreadyAssignedException extends RuntimeException{

	public EmailIsAlreadyAssignedException(String message){
        super(message);
    }

}
