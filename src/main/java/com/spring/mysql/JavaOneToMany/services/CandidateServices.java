package com.spring.mysql.JavaOneToMany.services;

import com.spring.mysql.JavaOneToMany.configuration.security.UserDetailsImpl;
import com.spring.mysql.JavaOneToMany.entities.Candidate;
import com.spring.mysql.JavaOneToMany.entities.Career;
import com.spring.mysql.JavaOneToMany.repositories.CandidateRepositorie;
import com.spring.mysql.JavaOneToMany.repositories.CareerRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateServices  {
    @Autowired
    private CandidateRepositorie candidateRepositorie;
    @Autowired
    private CareerRepositorie careerRepositorie;

    public Candidate save (Candidate candidate){
        return this.candidateRepositorie.save(candidate);
    }
    public List<Candidate> findAll (){
        return this.candidateRepositorie.findAll();
    }
    public Optional<Candidate> findById (Long id){
        return this.candidateRepositorie.findById(id);
    }
    public void deleteById (Long id){
        this.candidateRepositorie.deleteById(id);
    }
    public Candidate update (Long id, Candidate candidate){
        Optional<Candidate> oldCandidate = this.candidateRepositorie.findById(id);
        if(oldCandidate.isEmpty())
            return null;
        Optional<Career> newCareer = this.careerRepositorie.findById(candidate.getCareer().getId());
        candidate.setId(id);
        candidate.setCareer(newCareer.get());
        return this.candidateRepositorie.save(candidate);
    }

}
