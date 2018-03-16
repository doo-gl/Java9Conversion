package doo.gl.user.component;

import org.springframework.stereotype.Component;

import doo.gl.user.model.dto.UserRoleDTO;
import doo.gl.user.model.entity.UserRole;

@Component
public class UserRoleMapper {

    public UserRoleDTO map(UserRole userRole) {
        return UserRoleDTO.builder()
            .id(userRole.getId())
            .creationDate(userRole.getCreationDate())
            .lastModifiedDate(userRole.getLastModifiedDate())
            .value(userRole.getValue())
            .roleTypeCode(userRole.getRoleType().getCode())
            .build();
    }

}
