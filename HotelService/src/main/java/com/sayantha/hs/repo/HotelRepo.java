package com.sayantha.hs.repo;

import com.sayantha.hs.entity.HotelDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HotelRepo extends JpaRepository<HotelDetails, Integer> {
//    Optional<HotelDetails> findByName(String name);

}
