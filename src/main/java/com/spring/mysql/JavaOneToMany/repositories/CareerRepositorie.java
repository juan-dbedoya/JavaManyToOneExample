package com.spring.mysql.JavaOneToMany.repositories;

import com.spring.mysql.JavaOneToMany.entities.Career;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CareerRepositorie extends JpaRepository<Career, Long> {
}
