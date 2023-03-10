package africa.semicolon.evoting.exceptions.specific;

import africa.semicolon.evoting.exceptions.ApiRequestException;
import org.springframework.http.HttpStatus;

public class UserAlreadyVotedException extends ApiRequestException {

    public UserAlreadyVotedException() {
        this("User already voted for this category");
    }

    public UserAlreadyVotedException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
