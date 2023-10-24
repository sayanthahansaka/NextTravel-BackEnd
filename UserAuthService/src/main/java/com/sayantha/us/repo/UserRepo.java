package com.sayantha.us.repo;


import com.sayantha.us.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,String> {
    Optional<User> findByUserName(String userName);
}
