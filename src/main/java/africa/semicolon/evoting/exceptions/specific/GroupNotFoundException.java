package africa.semicolon.evoting.exceptions.specific;

import africa.semicolon.evoting.exceptions.ApiRequestException;
import org.springframework.http.HttpStatus;

public class GroupNotFoundException extends ApiRequestException {
    public GroupNotFoundException() {
        this("Group not found");
    }

    public GroupNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
