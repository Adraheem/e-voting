package africa.semicolon.evoting.exceptions.specific;

import africa.semicolon.evoting.exceptions.ApiRequestException;
import org.springframework.http.HttpStatus;

public class UnauthorizedRequestException extends ApiRequestException {

    public UnauthorizedRequestException() {
        this("Unauthorized request");
    }

    public UnauthorizedRequestException(String message) {
        super(message, HttpStatus.UNAUTHORIZED);
    }
}

