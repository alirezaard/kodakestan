package com.kodakestan.kodak.models.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Alireza
 * @version 1.0.0
 * @date 6.5.2020
 */
@Data
@Document("category")
public class Category {
    @MongoId
    private ObjectId id;
    @Indexed
    private String uuid = UUID.randomUUID().toString();
    private String title;
    private String description;
    private String parentUUID;
    @DBRef
    private List<Category> subCategory;


    public List<String> allSubCategory() {
        List<String> result = new ArrayList<>();
        result.add(this.getUuid());
        if (getSubCategory() != null && !getSubCategory().isEmpty())
            getSubCategory().forEach(e -> result.addAll(e.allSubCategory()));
        return result;
    }
}