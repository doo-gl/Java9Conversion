package doo.gl.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import doo.gl.user.model.entity.RoleType;

public interface RoleTypeRepository extends JpaRepository<RoleType, String> {

    RoleType getByCode(String code);

}
