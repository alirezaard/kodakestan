package com.kodakestan.kodak.dao;

import com.kodakestan.kodak.models.entities.Slider;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlidRepo extends MongoRepository<Slider, ObjectId> {

}
