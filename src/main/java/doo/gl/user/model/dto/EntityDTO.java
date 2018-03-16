package doo.gl.user.model.dto;

import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class EntityDTO {

    private String id;
    private ZonedDateTime creationDate;
    private ZonedDateTime lastModifiedDate;

}
