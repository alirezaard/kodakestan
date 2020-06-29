package com.kodakestan.kodak.dao;

import com.kodakestan.kodak.models.entities.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Alireza
 * @version 1.0.0
 * date 6.5.2020
 */
@Repository
public interface UserRepo extends MongoRepository<User, ObjectId> {
    Optional<User> findFirstByEmailAndActiveIsTrue(String email);
    Optional<User> findFirstByUuid(String uuid);
}
