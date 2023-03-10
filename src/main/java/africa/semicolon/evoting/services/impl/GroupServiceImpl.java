package africa.semicolon.evoting.services.impl;

import africa.semicolon.evoting.data.dtos.requests.CreateGroupRequestDto;
import africa.semicolon.evoting.data.dtos.requests.GroupRequestDto;
import africa.semicolon.evoting.data.dtos.requests.UserGroupRequestDto;
import africa.semicolon.evoting.data.dtos.responses.DataResponseDto;
import africa.semicolon.evoting.data.models.GroupEntity;
import africa.semicolon.evoting.data.models.UserEntity;
import africa.semicolon.evoting.data.models.UserGroupEntity;
import africa.semicolon.evoting.data.repositories.GroupRepository;
import africa.semicolon.evoting.data.repositories.UserGroupRepository;
import africa.semicolon.evoting.exceptions.specific.GroupNotFoundException;
import africa.semicolon.evoting.exceptions.specific.UserAlreadyInGroupException;
import africa.semicolon.evoting.exceptions.specific.UserNotFoundException;
import africa.semicolon.evoting.services.GroupService;
import africa.semicolon.evoting.services.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class GroupServiceImpl implements GroupService {

    private GroupRepository groupRepository;
    private UserGroupRepository userGroupRepository;
    private UserService userService;

    @Override
    public GroupEntity createGroup(CreateGroupRequestDto request) {
        GroupEntity newGroup = GroupEntity.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();
        return groupRepository.save(newGroup);
    }

    @Override
    public GroupEntity updateGroup(GroupRequestDto request) {
        if (!groupRepository.existsById(request.getId())) throw new GroupNotFoundException();

        GroupEntity updatedGroup = GroupEntity.builder()
                .id(request.getId())
                .name(request.getName())
                .description(request.getDescription())
                .build();
        return groupRepository.save(updatedGroup);
    }

    @Override
    public Optional<GroupEntity> findById(Long id) {
        return groupRepository.findById(id);
    }

    @Override
    public void deleteGroup(Long id) {
        if (!groupRepository.existsById(id)) throw new GroupNotFoundException();

        groupRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        groupRepository.deleteAll();
    }

    @Override
    public List<UserEntity> findAllUsersInGroup(Long groupId) {
        GroupEntity group = this.findById(groupId).orElseThrow(GroupNotFoundException::new);
        var users = userGroupRepository.findAllByGroup(group);
        log.info(users.toString());
        return null;
    }

    @Override
    public DataResponseDto<String> addUserToGroup(UserGroupRequestDto request) {
        UserEntity user = userService.findById(request.getUserId()).orElseThrow(UserNotFoundException::new);
        GroupEntity group = this.findById(request.getGroupId()).orElseThrow(GroupNotFoundException::new);

        if (userGroupRepository.existsByUserAndGroup(user, group)) throw new UserAlreadyInGroupException();

        var userGroup = UserGroupEntity.builder()
                .user(user)
                .group(group)
                .build();

        userGroupRepository.save(userGroup);
        return DataResponseDto.<String>builder().data("User added to group successfully").build();
    }

    @Override
    public DataResponseDto<String> removeUserFromGroup(UserGroupRequestDto request) {
        return null;
    }
}
