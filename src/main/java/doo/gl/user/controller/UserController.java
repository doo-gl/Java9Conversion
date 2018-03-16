package doo.gl.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

import java.util.List;

import doo.gl.user.model.dto.AddMetadataDTO;
import doo.gl.user.model.dto.AddRoleDTO;
import doo.gl.user.model.dto.UserDTO;
import doo.gl.user.service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Inject
    private UserService userService;

    @RequestMapping(path = "/{userId}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> getUser(
        @PathVariable String userId
    ) {
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<UserDTO> createUser(@RequestBody String username) {
        return ResponseEntity.ok(userService.createUser(username));
    }

    @RequestMapping(path = "/{userId}/action/addMetadata", method = RequestMethod.PUT)
    public ResponseEntity<UserDTO> addMetadataToUser(
        @PathVariable String userId,
        @RequestBody AddMetadataDTO addMetadataDTO
    ) {
        return ResponseEntity.ok(userService.addMetadataToUser(userId, addMetadataDTO));
    }

    @RequestMapping(path = "/{userId}/action/addRole", method = RequestMethod.PUT)
    public ResponseEntity<UserDTO> addRoleToUser(
        @PathVariable String userId,
        @RequestBody AddRoleDTO addRoleDTO
    ) {
        return ResponseEntity.ok(userService.addRoleToUser(userId, addRoleDTO));
    }

}
