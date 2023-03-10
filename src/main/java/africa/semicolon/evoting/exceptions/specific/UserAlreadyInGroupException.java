package africa.semicolon.evoting.exceptions.specific;

import africa.semicolon.evoting.exceptions.ApiRequestException;
import org.springframework.http.HttpStatus;

public class UserAlreadyInGroupException extends ApiRequestException {

    public UserAlreadyInGroupException() {
        this("User already in group");
    }

    public UserAlreadyInGroupException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
