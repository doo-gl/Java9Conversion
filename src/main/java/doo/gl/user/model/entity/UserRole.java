package doo.gl.user.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "role")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
public class UserRole extends doo.gl.user.model.entity.Entity implements Comparable<UserRole> {

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="role_type_id", referencedColumnName="id")
    private RoleType roleType;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "value")
    private String value;

    @Column(name = "ordinal")
    private int ordinal;

    @Override
    public int compareTo(UserRole that) {
        return Integer.compare(this.getOrdinal(), that.getOrdinal());
    }
}
