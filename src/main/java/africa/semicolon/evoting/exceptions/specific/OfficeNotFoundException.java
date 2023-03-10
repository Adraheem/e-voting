package africa.semicolon.evoting.exceptions.specific;

import africa.semicolon.evoting.exceptions.ApiRequestException;
import org.springframework.http.HttpStatus;

public class OfficeNotFoundException extends ApiRequestException {

    public OfficeNotFoundException() {
        this("Office not found");
    }

    public OfficeNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
