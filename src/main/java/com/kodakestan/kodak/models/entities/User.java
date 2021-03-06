package com.kodakestan.kodak.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

/**
 * @author Alireza
 * @version 1.0.0
 * date 6.5.2020
 */
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
    @JsonIgnore
    @NotNull
    private String password;
    @DBRef
    private Image logo;
    private Role role;
    private Gender gender;
    private Long birthday;
    @DBRef(lazy = true)
    private Boolean active = false;
    private List<Children> children;
}