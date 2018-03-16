package doo.gl.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import doo.gl.user.model.entity.MetadataType;

public interface MetadataTypeRepository extends JpaRepository<MetadataType, String> {

    MetadataType getByCode(String code);

}
