package doo.gl.user.model.dto;

import java.time.ZonedDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends EntityDTO {

    @Builder
    public UserDTO(
        String id,
        ZonedDateTime creationDate,
        ZonedDateTime lastModifiedDate,
        String username,
        List<UserMetadataDTO> userMetadataDTOS,
        List<UserRoleDTO> userRoleDTOS
    ) {
        super(id, creationDate, lastModifiedDate);
        this.username = username;
        this.userMetadataDTOS = userMetadataDTOS;
        this.userRoleDTOS = userRoleDTOS;
    }

    private String username;
    private List<UserMetadataDTO> userMetadataDTOS;
    private List<UserRoleDTO> userRoleDTOS;

}
