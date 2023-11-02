package com.sayantha.gs.repo;

import com.sayantha.gs.entity.GuideDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuideRepository extends MongoRepository<GuideDetails, Integer> {
    @Query(value = "{}", fields = "{ 'guideID' : 1 }")
    List<Integer> getAllId();
}
