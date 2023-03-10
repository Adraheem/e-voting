package africa.semicolon.evoting.services;

import africa.semicolon.evoting.data.dtos.requests.GroupRequestDto;
import africa.semicolon.evoting.data.dtos.requests.UserGroupRequestDto;
import africa.semicolon.evoting.data.dtos.requests.CreateGroupRequestDto;
import africa.semicolon.evoting.data.dtos.responses.DataResponseDto;
import africa.semicolon.evoting.data.models.GroupEntity;
import africa.semicolon.evoting.data.models.UserEntity;

import java.util.List;
import java.util.Optional;

public interface GroupService {

    GroupEntity createGroup(CreateGroupRequestDto request);

    GroupEntity updateGroup(GroupRequestDto request);

    Optional<GroupEntity> findById(Long id);

    void deleteGroup(Long id);
    void deleteAll();

    List<UserEntity> findAllUsersInGroup(Long groupId);

    DataResponseDto<String> addUserToGroup(UserGroupRequestDto request);

    DataResponseDto<String> removeUserFromGroup(UserGroupRequestDto request);

}
