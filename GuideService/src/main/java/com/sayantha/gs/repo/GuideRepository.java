package com.sayantha.gs.repo;



import com.sayantha.gs.entity.GuideDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuideRepository extends MongoRepository<GuideDetails, Integer> {

}
