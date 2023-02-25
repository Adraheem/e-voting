package africa.semicolon.evoting.data.dtos.responses;

import africa.semicolon.evoting.data.models.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    private String firstName, lastName, emailAddress;

    private LocalDateTime createdAt;

    public UserDto(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.firstName = userEntity.getFirstName();
        this.lastName = userEntity.getLastName();
        this.emailAddress = userEntity.getEmailAddress();
        this.createdAt = userEntity.getCreatedAt();
    }
}
