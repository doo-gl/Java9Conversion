package doo.gl.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import doo.gl.user.model.entity.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, String> {

}
