package com.spring.mysql.JavaOneToMany.services;

import com.spring.mysql.JavaOneToMany.configuration.security.UserDetailsImpl;
import com.spring.mysql.JavaOneToMany.entities.Candidate;
import com.spring.mysql.JavaOneToMany.entities.User;
import com.spring.mysql.JavaOneToMany.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = this.userRepository.findOneByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("NOT FOUND"));
        return new UserDetailsImpl(user);
    }

}
