package com.example.springcrudtask.services;

import com.example.springcrudtask.entities.Client;
import com.example.springcrudtask.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client user=clientRepository.findByUsername(username);
        if (user==null){
            throw  new UsernameNotFoundException("Vartotojas nerastas");
        }
        return user;
    }
}