package com.kodakestan.kodak.models.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

/**
 * @author Alireza
 * @version 1.0.0
 * date 6.5.2020
 */
@Data
@Document("image")
public class Image {
    @MongoId
    private ObjectId id;
    private Boolean deleted = false;
}
