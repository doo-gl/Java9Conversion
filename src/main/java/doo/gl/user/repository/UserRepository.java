package doo.gl.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import doo.gl.user.model.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

}
