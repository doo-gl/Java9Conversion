package doo.gl.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import doo.gl.user.model.entity.UserMetadata;

public interface UserMetadataRepository extends JpaRepository<UserMetadata, String> {
}
