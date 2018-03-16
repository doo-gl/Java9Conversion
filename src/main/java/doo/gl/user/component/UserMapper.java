package doo.gl.user.component;

import org.springframework.stereotype.Component;

import javax.inject.Inject;

import java.util.Collections;

import doo.gl.user.model.dto.UserDTO;
import doo.gl.user.model.entity.User;

import static java.util.stream.Collectors.toList;

@Component
public class UserMapper {

    @Inject
    private UserRoleMapper userRoleMapper;

    @Inject
    private UserMetadataMapper userMetadataMapper;

    public UserDTO map(User user) {
        return UserDTO.builder()
            .id(user.getId())
            .creationDate(user.getCreationDate())
            .lastModifiedDate(user.getLastModifiedDate())
            .username(user.getUsername())
            .userMetadataDTOS(
                user.getUserMetadatas() != null ? user.getUserMetadatas().stream()
                    .map(userMetadataMapper::map)
                    .collect(toList()) :
                    Collections.emptyList()
            )
            .userRoleDTOS(
                user.getUserRoles() != null ? user.getUserRoles().stream()
                    .map(userRoleMapper::map)
                    .collect(toList()) :
                    Collections.emptyList()
            )
            .build();
    }

}
