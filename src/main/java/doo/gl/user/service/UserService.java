package doo.gl.user.service;

import org.springframework.stereotype.Service;

import javax.inject.Inject;

import java.util.List;

import doo.gl.user.component.transactional.UserCreator;
import doo.gl.user.component.transactional.UserMetadataUpdater;
import doo.gl.user.component.transactional.UserRetriever;
import doo.gl.user.component.transactional.UserRoleUpdater;
import doo.gl.user.model.dto.AddMetadataDTO;
import doo.gl.user.model.dto.AddRoleDTO;
import doo.gl.user.model.dto.UserDTO;

@Service
public class UserService {

    @Inject
    private UserRetriever userRetriever;

    @Inject
    private UserCreator userCreator;

    @Inject
    private UserMetadataUpdater userMetadataUpdater;

    @Inject
    private UserRoleUpdater userRoleUpdater;

    public UserDTO getUser(String userId) {
        return userRetriever.retrieve(userId);
    }

    public List<UserDTO> getUsers() {
        return userRetriever.retrieveUsers();
    }

    public UserDTO createUser(String username) {
        return userCreator.create(username);
    }

    public UserDTO addMetadataToUser(String userId, AddMetadataDTO addMetadataDTO) {
        return userMetadataUpdater.update(userId, addMetadataDTO);
    }

    public UserDTO addRoleToUser(String userId, AddRoleDTO addRoleDTO) {
        return userRoleUpdater.update(userId, addRoleDTO);
    }

}
