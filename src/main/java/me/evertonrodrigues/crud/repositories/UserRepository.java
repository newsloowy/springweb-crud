package me.evertonrodrigues.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import me.evertonrodrigues.crud.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
