package africa.semicolon.evoting.exceptions.specific;

import africa.semicolon.evoting.exceptions.ApiRequestException;
import org.springframework.http.HttpStatus;

public class PostNotFoundException extends ApiRequestException {

    public PostNotFoundException() {
        this("Post not found");
    }

    public PostNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
