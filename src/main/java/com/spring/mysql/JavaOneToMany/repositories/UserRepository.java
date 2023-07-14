package com.spring.mysql.JavaOneToMany.repositories;

import com.spring.mysql.JavaOneToMany.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findOneByEmail(String email);

}
