package com.kodakestan.kodak.models.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;
import java.util.UUID;

/**
 * @author Alireza
 * @version 1.0.0
 * date 6.5.2020
 */
@Data
@Document("product")
public class Product {
    @MongoId
    private ObjectId id;
    @Indexed
    private String uuid = UUID.randomUUID().toString();
    @DBRef
    private List<Image> image;
    private Long lastModify;
    private Long price;
    private Long discount;
    private String description;
    private int numberOfGoods;
    private Gender gender;
    private int minAge;
    private int maxAge;
    private Boolean isDeleted = false;
    private String categoryUUID;
    private Long like = 0L;
}
