package doo.gl.user.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import java.time.ZonedDateTime;
import java.util.Objects;

import doo.gl.user.configuration.DateToZonedDateTimeConverter;
import doo.gl.user.configuration.DateUtils;
import lombok.ToString;

@MappedSuperclass
@ToString
public class Entity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name="creation_date")
    @Convert(converter = DateToZonedDateTimeConverter.class)
    private ZonedDateTime creationDate;

    @Column(name="last_modified_date")
    @Convert(converter = DateToZonedDateTimeConverter.class)
    private ZonedDateTime lastModifiedDate;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public ZonedDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(ZonedDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @PrePersist
    public void setCreatedDateToNow() {
        setCreationDate(DateUtils.nowUTC());
        setLastModifiedDate(DateUtils.nowUTC());
    }

    @PreUpdate
    public void setModifiedDateToNow() {
        setLastModifiedDate(DateUtils.nowUTC());
    }

    @Override
    public boolean equals(Object other) {
        if (getClass().isAssignableFrom(other.getClass())) {
            Entity entity = (Entity) other;
            return entity.id == null && id == null ? super.equals(other) : Objects.equals(entity.id, id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id == null ? super.hashCode() : Objects.hashCode(id);
    }

    public boolean deepEquals(Object other) {
        return equals(other);
    }
}
