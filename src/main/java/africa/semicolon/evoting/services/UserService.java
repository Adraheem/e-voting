package africa.semicolon.evoting.services;

import africa.semicolon.evoting.data.models.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserEntity save(UserEntity user);

    Boolean exists(String username);

    Optional<UserEntity> findById(Long id);

    List<UserEntity> findAllByGroupId(Long groupId);

    void deleteAll();
}
