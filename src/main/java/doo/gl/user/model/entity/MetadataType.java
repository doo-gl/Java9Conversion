package doo.gl.user.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "metadata_type")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
public class MetadataType extends doo.gl.user.model.entity.Entity {

    @Column(name="code")
    private String code;

}
