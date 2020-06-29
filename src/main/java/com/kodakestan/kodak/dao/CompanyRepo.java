package com.kodakestan.kodak.dao;

import com.kodakestan.kodak.models.entities.Company;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepo extends MongoRepository<Company, ObjectId> {
}
