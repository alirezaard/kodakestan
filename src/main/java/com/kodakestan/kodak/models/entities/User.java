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

@Data
@Document("user")
public class User {
    @MongoId
    private ObjectId id;
    @Indexed
    private String uuid = UUID.randomUUID().toString();
    private String fullName;
    private String email;
    private String phoneNumber;
    private String password;
    @DBRef
    private Image logo;
    private Role role;
    private Gender gender;
    private Date birthday;
    @DBRef
    private List<Children> children;
    private Boolean active = false;
}