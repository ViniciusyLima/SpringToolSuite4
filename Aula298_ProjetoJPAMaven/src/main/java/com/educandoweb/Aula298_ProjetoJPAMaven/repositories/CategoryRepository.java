package com.educandoweb.Aula298_ProjetoJPAMaven.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.Aula298_ProjetoJPAMaven.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
