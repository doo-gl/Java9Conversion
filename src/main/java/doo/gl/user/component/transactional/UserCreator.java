package doo.gl.user.component.transactional;

import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.transaction.Transactional;

import doo.gl.user.component.UserMapper;
import doo.gl.user.model.dto.UserDTO;
import doo.gl.user.model.entity.User;
import doo.gl.user.repository.UserRepository;

@Component
@Transactional
public class UserCreator {

    @Inject
    private UserRepository userRepository;

    @Inject
    private UserMapper userMapper;

    public UserDTO create(String username) {

        User user = User.builder()
            .username(username)
            .build();

        User persistedUser = userRepository.saveAndFlush(user);

        return userMapper.map(persistedUser);
    }

}
