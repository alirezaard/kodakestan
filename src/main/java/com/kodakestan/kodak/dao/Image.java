package com.kodakestan.kodak.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Image extends MongoRepository<Image, ObjectId> {

}
