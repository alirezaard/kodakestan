package com.kodakestan.kodak.models.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;
import java.util.UUID;

@Data
@Document("address")
public class Address {
    @MongoId
    private ObjectId id;
    @Indexed
    private String uuid = UUID.randomUUID().toString();
    private String state;
    private String city;
    private String neighborhood;
    private String street;
    private String alley;
    private String number;
    @DBRef
    private List<SocialNetwork> socialNetworks;
    private String website;
    private List<String> telephone;
}
