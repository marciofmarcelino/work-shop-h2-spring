package com.marciofmf.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marciofmf.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
