package doo.gl.user.component.transactional;

import org.springframework.stereotype.Component;

import javax.inject.Inject;

import java.util.List;

import doo.gl.user.component.UserMapper;
import doo.gl.user.model.dto.UserDTO;
import doo.gl.user.repository.UserRepository;

import static java.util.stream.Collectors.toList;

@Component
public class UserRetriever {

    @Inject
    private UserRepository userRepository;

    @Inject
    private UserMapper userMapper;

    public UserDTO retrieve(String userId) {
        return userMapper.map(
            userRepository.findOne(userId)
        );
    }

    public List<UserDTO> retrieveUsers() {
        return userRepository.findAll().stream()
            .map(userMapper::map)
            .collect(toList());
    }

}
