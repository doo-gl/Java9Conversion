package doo.gl.user.component.transactional;

import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.transaction.Transactional;

import java.util.SortedSet;
import java.util.TreeSet;

import doo.gl.user.component.UserMapper;
import doo.gl.user.exception.EntityNotFoundException;
import doo.gl.user.model.dto.AddRoleDTO;
import doo.gl.user.model.dto.UserDTO;
import doo.gl.user.model.entity.MetadataType;
import doo.gl.user.model.entity.RoleType;
import doo.gl.user.model.entity.User;
import doo.gl.user.model.entity.UserMetadata;
import doo.gl.user.model.entity.UserRole;
import doo.gl.user.repository.RoleTypeRepository;
import doo.gl.user.repository.UserRepository;

@Component
@Transactional
public class UserRoleUpdater {

    @Inject
    private UserRepository userRepository;

    @Inject
    private RoleTypeRepository roleTypeRepository;

    @Inject
    private UserMapper userMapper;

    public UserDTO update(String userId, AddRoleDTO addRoleDTO) {
        RoleType roleType = roleTypeRepository.getByCode(addRoleDTO.getRoleTypeCode());

        if (roleType == null) {
            throw new EntityNotFoundException("Failed to find role type with code: " + addRoleDTO.getRoleTypeCode());
        }

        User user = userRepository.findOne(userId);

        if (user == null) {
            throw new EntityNotFoundException("Failed to find user with id: " + userId);
        }

        SortedSet<UserRole> userRoles = user.getUserRoles();

        if (userRoles == null) {
            userRoles = new TreeSet<>();
        }

        userRoles.add(
            UserRole.builder()
                .roleType(roleType)
                .ordinal(userRoles.size())
                .userId(userId)
                .value(addRoleDTO.getValue())
                .build()
        );

        user.setUserRoles(userRoles);

        User persistedUser = userRepository.saveAndFlush(user);

        return userMapper.map(persistedUser);
    }

}
