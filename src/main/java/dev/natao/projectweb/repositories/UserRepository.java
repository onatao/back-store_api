package dev.natao.projectweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.natao.projectweb.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
