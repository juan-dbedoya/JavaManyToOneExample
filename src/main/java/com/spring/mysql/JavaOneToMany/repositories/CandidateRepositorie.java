package com.spring.mysql.JavaOneToMany.repositories;

import com.spring.mysql.JavaOneToMany.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidateRepositorie extends JpaRepository<Candidate,Long> {
}
