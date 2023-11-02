package com.sayantha.us.repo;


import com.sayantha.us.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User,String> {
    Optional<User> findByUserName(String userName);

    @Query("SELECT u.userId from User u order by u.userId DESC")
    List<String> getAllId();
}
