package doo.gl.user.component;

import org.springframework.stereotype.Component;

import doo.gl.user.model.dto.UserMetadataDTO;
import doo.gl.user.model.entity.UserMetadata;

@Component
public class UserMetadataMapper {

    public UserMetadataDTO map(UserMetadata userMetadata) {
        return UserMetadataDTO.builder()
            .id(userMetadata.getId())
            .creationDate(userMetadata.getCreationDate())
            .lastModifiedDate(userMetadata.getLastModifiedDate())
            .value(userMetadata.getValue())
            .metadataTypeCode(userMetadata.getMetadataType().getCode())
            .build();
    }

}
