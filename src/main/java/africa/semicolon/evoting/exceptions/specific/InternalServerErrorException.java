package africa.semicolon.evoting.exceptions.specific;

import africa.semicolon.evoting.exceptions.ApiRequestException;
import org.springframework.http.HttpStatus;

public class InternalServerErrorException extends ApiRequestException {
    public InternalServerErrorException() {
        this("Internal server error");
    }

    public InternalServerErrorException(String message) {
        super(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
