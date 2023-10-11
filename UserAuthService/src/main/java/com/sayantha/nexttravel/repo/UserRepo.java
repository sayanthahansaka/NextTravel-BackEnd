package com.sayantha.nexttravel.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepo extends JpaRepository<com.sayantha.nexttravel.entity.UserDetails,String> {
    Optional<UserDetails> findByUserName (String username);
}
