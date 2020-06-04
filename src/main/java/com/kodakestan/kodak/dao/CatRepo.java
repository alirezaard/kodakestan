package com.kodakestan.kodak.dao;

import com.kodakestan.kodak.models.entities.Category;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepo extends MongoRepository<Category, ObjectId> {

}
