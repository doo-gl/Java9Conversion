package doo.gl.user.component.transactional;

import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.transaction.Transactional;

import java.util.SortedSet;
import java.util.TreeSet;

import doo.gl.user.component.UserMapper;
import doo.gl.user.exception.EntityNotFoundException;
import doo.gl.user.model.dto.AddMetadataDTO;
import doo.gl.user.model.dto.UserDTO;
import doo.gl.user.model.entity.MetadataType;
import doo.gl.user.model.entity.User;
import doo.gl.user.model.entity.UserMetadata;
import doo.gl.user.repository.MetadataTypeRepository;
import doo.gl.user.repository.UserRepository;

@Component
@Transactional
public class UserMetadataUpdater {

    @Inject
    private UserRepository userRepository;

    @Inject
    private MetadataTypeRepository metadataTypeRepository;

    @Inject
    private UserMapper userMapper;

    public UserDTO update(String userId, AddMetadataDTO addMetadataDTO) {

        MetadataType metadataType = metadataTypeRepository.getByCode(addMetadataDTO.getMetadataTypeCode());

        if (metadataType == null) {
            throw new EntityNotFoundException("Failed to find metadata type with code: " + addMetadataDTO.getMetadataTypeCode());
        }

        User user = userRepository.findOne(userId);

        if (user == null) {
            throw new EntityNotFoundException("Failed to find user with id: " + userId);
        }

        SortedSet<UserMetadata> userMetadatas = user.getUserMetadatas();

        if (userMetadatas == null) {
            userMetadatas = new TreeSet<>();
        }

        userMetadatas.add(
            UserMetadata.builder()
                .metadataType(metadataType)
                .ordinal(userMetadatas.size())
                .userId(userId)
                .value(addMetadataDTO.getValue())
                .build()
        );

        user.setUserMetadatas(userMetadatas);

        User persistedUser = userRepository.saveAndFlush(user);

        return userMapper.map(persistedUser);
    }

}
