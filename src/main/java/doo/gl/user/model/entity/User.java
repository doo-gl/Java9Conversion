package doo.gl.user.model.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import java.util.SortedSet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "end_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
public class User extends doo.gl.user.model.entity.Entity {

    @Column(name = "username")
    private String username;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @Cascade({ CascadeType.ALL })
    @Fetch(FetchMode.SUBSELECT)
    @OrderBy("creation_date ASC")
    private SortedSet<UserMetadata> userMetadatas;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @Cascade({ CascadeType.ALL })
    @Fetch(FetchMode.SUBSELECT)
    @OrderBy("creation_date ASC")
    private SortedSet<UserRole> userRoles;

}
