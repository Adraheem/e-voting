package africa.semicolon.evoting.data.dtos.responses;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenResponseDto {

    private String token;

}
