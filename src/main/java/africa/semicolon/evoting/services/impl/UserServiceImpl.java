package africa.semicolon.evoting.services.impl;

import africa.semicolon.evoting.data.models.UserEntity;
import africa.semicolon.evoting.data.repositories.UserGroupRepository;
import africa.semicolon.evoting.data.repositories.UserRepository;
import africa.semicolon.evoting.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserGroupRepository userGroupRepository;


    @Override
    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public Boolean exists(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public Optional<UserEntity> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<UserEntity> findAllByGroupId(Long groupId) {
        return null;
    }

    @Override
    public void deleteAll() {
        List<UserEntity> users = userRepository.findAll();
        for (UserEntity user : users){
            userGroupRepository.deleteAllByUser(user);
        }
//        userRepository.deleteAll();
    }
}
