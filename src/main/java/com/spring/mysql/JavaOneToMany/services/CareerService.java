package com.spring.mysql.JavaOneToMany.services;

import com.spring.mysql.JavaOneToMany.entities.Candidate;
import com.spring.mysql.JavaOneToMany.entities.Career;
import com.spring.mysql.JavaOneToMany.repositories.CareerRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CareerService  {
    @Autowired
    private CareerRepositorie careerRepositorie;

    public Career save (Career career){
        return this.careerRepositorie.save(career);
    }
    public List<Career> findAll (){
        return this.careerRepositorie.findAll();
    }
    public Optional<Career> findById (Long id){
        return this.careerRepositorie.findById(id);
    }
    public void deleteById(Long id){
        this.careerRepositorie.deleteById(id);
    }
    public Career update (Long id, Career career)
    {
        Optional<Career> oldCareer = this.careerRepositorie.findById(id);
        if(oldCareer.isEmpty())
            return null;
        career.setId(id);
        return this.careerRepositorie.save(career);
    }
    public List<Candidate> listCandidateByCareerId (Long id)
    {
        return this.careerRepositorie.findById(id).get().getCandidates();
    }

}
