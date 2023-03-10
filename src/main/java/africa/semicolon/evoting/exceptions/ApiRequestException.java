package africa.semicolon.evoting.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class ApiRequestException extends RuntimeException {

    @Getter
    private HttpStatus status = HttpStatus.BAD_REQUEST;

    public ApiRequestException(){
        this("API Request Error");
    }

    public ApiRequestException(String message){
        super(message);
    }

    public ApiRequestException(String message, HttpStatus status) {
        this(message);
        this.status = status;
    }
}
