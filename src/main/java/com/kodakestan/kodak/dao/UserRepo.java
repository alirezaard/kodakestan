package com.kodakestan.kodak.dao;

import com.kodakestan.kodak.models.entities.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<User, ObjectId> {
    User findFirstByEmail(String email);
}
