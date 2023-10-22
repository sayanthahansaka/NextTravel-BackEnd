package com.sayanthauser.userauthservice.repo;


import com.sayanthauser.userauthservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,String> {
    Optional<User> findByUserName(String userName);
}
