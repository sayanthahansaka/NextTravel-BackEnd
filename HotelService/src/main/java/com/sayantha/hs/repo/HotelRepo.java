package com.sayantha.hs.repo;

import com.sayantha.hs.entity.HotelDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepo extends JpaRepository<HotelDetails, Integer> {
    // Optional<HotelDetails> findByName(String name);

    @Query("SELECT MAX(h.hotelID) FROM HotelDetails h")
    Integer findMaxID();

    List<HotelDetails> findByPackageID(Integer packageID);
}
