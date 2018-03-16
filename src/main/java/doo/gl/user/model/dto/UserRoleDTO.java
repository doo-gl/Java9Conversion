package doo.gl.user.model.dto;

import java.time.ZonedDateTime;

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
public class UserRoleDTO extends EntityDTO {

    @Builder
    public UserRoleDTO(
        String id,
        ZonedDateTime creationDate,
        ZonedDateTime lastModifiedDate,
        String value,
        String roleTypeCode
    ) {
        super(id, creationDate, lastModifiedDate);
        this.value = value;
        this.roleTypeCode = roleTypeCode;
    }

    private String value;
    private String roleTypeCode;

}
