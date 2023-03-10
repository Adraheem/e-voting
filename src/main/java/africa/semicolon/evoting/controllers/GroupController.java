package africa.semicolon.evoting.controllers;

import africa.semicolon.evoting.data.dtos.requests.CreateGroupRequestDto;
import africa.semicolon.evoting.data.dtos.requests.GroupRequestDto;
import africa.semicolon.evoting.data.dtos.requests.UserGroupRequestDto;
import africa.semicolon.evoting.data.models.GroupEntity;
import africa.semicolon.evoting.data.models.UserEntity;
import africa.semicolon.evoting.exceptions.specific.GroupNotFoundException;
import africa.semicolon.evoting.services.GroupService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/group")
@AllArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @PostMapping("")
    @Operation(summary = "Create new group")
    public ResponseEntity<GroupEntity> createGroup(@RequestBody @Valid CreateGroupRequestDto request) {
        return new ResponseEntity<>(groupService.createGroup(request), HttpStatus.CREATED);
    }

    @PutMapping("")
    @Operation(summary = "Update group")
    public ResponseEntity<GroupEntity> updateGroup(@RequestBody @Valid GroupRequestDto request) {
        return new ResponseEntity<>(groupService.updateGroup(request), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get group by id")
    public ResponseEntity<GroupEntity> getGroup(@PathVariable Long id) {
        GroupEntity group = groupService.findById(id).orElseThrow(GroupNotFoundException::new);
        return new ResponseEntity<>(group, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete group by id")
    public ResponseEntity<String> deleteGroup(@PathVariable Long id) {
        groupService.deleteGroup(id);
        return new ResponseEntity<>("Deleted successfully!", HttpStatus.OK);
    }

    @PostMapping("/{groupId}/user/{userId}")
    @Operation(summary = "Add user to group")
    public ResponseEntity<String> addUserToGroup(@PathVariable @Valid Long groupId, @PathVariable @Valid Long userId) {
        groupService.addUserToGroup(
                UserGroupRequestDto.builder().userId(userId).groupId(groupId).build()
        );
        return new ResponseEntity<>("Added successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{groupId}/user/{userId}")
    @Operation(summary = "Remove user from group")
    public ResponseEntity<String> removeUserFromGroup(@PathVariable @Valid Long groupId, @PathVariable @Valid Long userId) {
        groupService.removeUserFromGroup(
                UserGroupRequestDto.builder().userId(userId).groupId(groupId).build()
        );
        return new ResponseEntity<>("Removed successfully", HttpStatus.OK);
    }

    @GetMapping("/{groupId}/user/all")
    @Operation(summary = "Get all users in a group")
    public ResponseEntity<List<UserEntity>> getAllUsersInGroup(@PathVariable Long groupId) {
        return new ResponseEntity<>(groupService.findAllUsersInGroup(groupId), HttpStatus.OK);
    }
}
