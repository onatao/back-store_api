package dev.natao.projectweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.natao.projectweb.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
