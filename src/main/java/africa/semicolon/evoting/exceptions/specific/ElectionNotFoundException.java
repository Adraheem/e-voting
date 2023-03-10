package africa.semicolon.evoting.exceptions.specific;

import africa.semicolon.evoting.exceptions.ApiRequestException;
import org.springframework.http.HttpStatus;

public class ElectionNotFoundException extends ApiRequestException {

    public ElectionNotFoundException() {
        this("Election not found");
    }

    public ElectionNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
