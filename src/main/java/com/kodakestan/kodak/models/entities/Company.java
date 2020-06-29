package com.kodakestan.kodak.models.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.UUID;

@Data
@Document("company")
public class Company {
    @MongoId
    private ObjectId id;
    @Indexed
    private String uuid = UUID.randomUUID().toString();
    @DBRef
    private Image logo;
    @DBRef
    private Address address;

}
