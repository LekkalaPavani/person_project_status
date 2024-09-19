package com.ust.Ust_Projects.service;

import com.ust.Ust_Projects.model.Person;
import com.ust.Ust_Projects.repository.PersonRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class GroupUserDetailsService implements UserDetailsService {
    private PersonRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<Person> user =repo.findByUsername(username);
       return user.map(GroupUserDetails::new)
               .orElseThrow(()
               -> new UsernameNotFoundException(username+" Not found"));
    }

}
