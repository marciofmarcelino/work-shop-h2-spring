package com.marciofmf.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.marciofmf.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
