package africa.semicolon.evoting.exceptions.specific;

import africa.semicolon.evoting.exceptions.ApiRequestException;
import org.springframework.http.HttpStatus;

public class EmailAlreadyUsedException extends ApiRequestException {
    public EmailAlreadyUsedException() {
        this("Email already used");
    }

    public EmailAlreadyUsedException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
