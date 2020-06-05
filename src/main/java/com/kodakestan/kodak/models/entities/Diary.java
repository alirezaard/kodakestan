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
@Document("diary")
public class Diary {
    @MongoId
    private ObjectId id;
    @Indexed
    private String uuid = UUID.randomUUID().toString();
    @DBRef
    private List<Image> images;
    private String memories;
    private List<String> tags;
    private Date date;
    private String owner;
    private Long like = 0L;
    private String kidUUID;
    private Boolean visible = true;
    private Boolean trust = true;
}
