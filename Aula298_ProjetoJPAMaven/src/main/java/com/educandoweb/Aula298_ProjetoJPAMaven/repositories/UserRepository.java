package com.educandoweb.Aula298_ProjetoJPAMaven.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.Aula298_ProjetoJPAMaven.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
