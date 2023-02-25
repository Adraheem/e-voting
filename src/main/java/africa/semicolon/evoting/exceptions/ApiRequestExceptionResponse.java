package africa.semicolon.evoting.exceptions;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
@JsonPOJOBuilder
public class ApiRequestExceptionResponse {

    private String message;
    private HttpStatus status;

}
