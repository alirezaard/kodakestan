package com.kodakestan.kodak.dao;

import com.kodakestan.kodak.models.entities.Children;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alireza
 * @version 1.0.0
 * date 6.5.2020
 */
@Repository
public interface ChildRepo extends MongoRepository<Children, ObjectId> {

}
