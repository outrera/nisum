package nisum.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {

	@ExceptionHandler(value = PasswordValidationException.class)
    public ResponseEntity<UserExceptionResponse> handlePasswordValidationException(PasswordValidationException ex){
		UserExceptionResponse errorResponse = new UserExceptionResponse();
        errorResponse.setMessage(ex.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(value = EmailValidationException.class)
    public ResponseEntity<UserExceptionResponse> handleEmailValidationException(EmailValidationException ex){
		UserExceptionResponse errorResponse = new UserExceptionResponse();
        errorResponse.setMessage(ex.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(value = EmailIsAlreadyAssignedException.class)
    public ResponseEntity<UserExceptionResponse> handleEmailIsAlreadyAssignedException(EmailIsAlreadyAssignedException ex){
		UserExceptionResponse errorResponse = new UserExceptionResponse();
        errorResponse.setMessage(ex.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.CONFLICT);
    }
	
	@ExceptionHandler(value = GenericException.class)
    public ResponseEntity<UserExceptionResponse> handleGenericException(GenericException ex){
		UserExceptionResponse errorResponse = new UserExceptionResponse();
        errorResponse.setMessage(ex.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
