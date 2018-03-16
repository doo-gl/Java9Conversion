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
public class UserMetadataDTO extends EntityDTO {

    @Builder
    public UserMetadataDTO(
        String id,
        ZonedDateTime creationDate,
        ZonedDateTime lastModifiedDate,
        String value,
        String metadataTypeCode
    ) {
        super(id, creationDate, lastModifiedDate);
        this.value = value;
        this.metadataTypeCode = metadataTypeCode;
    }

    private String value;
    private String metadataTypeCode;

}
