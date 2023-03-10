package africa.semicolon.evoting.services.impl;

import africa.semicolon.evoting.data.dtos.requests.CreateGroupRequestDto;
import africa.semicolon.evoting.data.dtos.requests.GroupRequestDto;
import africa.semicolon.evoting.data.dtos.requests.UserGroupRequestDto;
import africa.semicolon.evoting.data.models.GroupEntity;
import africa.semicolon.evoting.data.models.UserEntity;
import africa.semicolon.evoting.services.GroupService;
import africa.semicolon.evoting.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@Slf4j
class GroupServiceImplTest {

    @Autowired
    private GroupService groupService;

    @Autowired
    private UserService userService;

    @BeforeEach
    void setUp() {
        groupService.deleteAll();
    }

    @AfterEach
    void tearDown() {
//        groupService.deleteAll();
    }

    @Test
    void createGroupTest() {
        var request = CreateGroupRequestDto.builder()
                .name("Nigerian Citizens")
                .description("A group that identifies all Nigerians")
                .build();
        GroupEntity group = groupService.createGroup(request);
        assertNotNull(group);
        assertNotNull(group.getId());
        assertEquals(1, group.getId());
        assertEquals(request.getName(), group.getName());
        assertEquals(request.getDescription(), group.getDescription());
    }

    @Test
    void updateGroupTest() {
        var request = CreateGroupRequestDto.builder()
                .name("Nigerian Citizens")
                .description("A group that identifies all Nigerians")
                .build();
        GroupEntity group = groupService.createGroup(request);

        var update = GroupRequestDto.builder()
                .id(group.getId())
                .name("Naija People")
                .description(null)
                .build();
        GroupEntity updatedGroup = groupService.updateGroup(update);

        assertNotNull(updatedGroup);
        assertEquals(group.getId(), updatedGroup.getId());
        assertNotEquals(group.getName(), updatedGroup.getName());
        assertNotEquals(group.getDescription(), updatedGroup.getDescription());
        assertNull(updatedGroup.getDescription());
    }

    @Test
    void findById() {
        var request = CreateGroupRequestDto.builder()
                .name("Nigerian Citizens")
                .description("A group that identifies all Nigerians")
                .build();
        GroupEntity group = groupService.createGroup(request);

        GroupEntity foundGroup = groupService.findById(group.getId()).orElse(null);
        assertNotNull(foundGroup);
        assertEquals(request.getName(), foundGroup.getName());
        assertEquals(request.getDescription(), foundGroup.getDescription());
    }

    @Test
    void deleteGroup() {
        var request = CreateGroupRequestDto.builder()
                .name("Nigerian Citizens")
                .description("A group that identifies all Nigerians")
                .build();
        GroupEntity group = groupService.createGroup(request);

        assertNotNull(group);
        GroupEntity savedGroup = groupService.findById(1L).orElse(null);
        assertNotNull(savedGroup);

        groupService.deleteGroup(1L);

        GroupEntity foundGroup = groupService.findById(1L).orElse(null);
        assertNull(foundGroup);
    }

    @Test
    void addUserToGroup() {
        var request = CreateGroupRequestDto.builder()
                .name("Nigerian Citizens")
                .description("A group that identifies all Nigerians")
                .build();
        groupService.createGroup(request);

//        assertEquals(0, userService.findAllByGroupId(1L).size());

        UserEntity user = UserEntity.builder()
                .firstName("John")
                .lastName("Doe")
                .emailAddress("johndoe@gmail.com")
                .build();

        userService.save(user);

        groupService.addUserToGroup(UserGroupRequestDto.builder().userId(1L).groupId(1L).build());

        var users = groupService.findAllUsersInGroup(1L);

//        List<UserEntity> users = userService.findAllByGroupId(1L);
//        assertEquals(1, users.size());
//        assertEquals(user.getFirstName(), users.get(0).getFirstName());
//        assertEquals(user.getLastName(), users.get(0).getLastName());
//        assertEquals(1L, users.get(0).getId());
        userService.deleteAll();
    }

    @Test
    void removeUserFromGroup() {
    }
}