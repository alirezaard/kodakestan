package com.kodakestan.kodak.models.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Alireza
 * @version 1.0.0
 * @date 6.5.2020
 */
@Data
@Document("children")
public class Children {
    @MongoId
    private ObjectId id;
    @Indexed
    private String uuid = UUID.randomUUID().toString();
    private String name;
    private Date birthday;
    @DBRef
    private List<Image> images;
    private String parentUUID;
}