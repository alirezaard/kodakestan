package com.kodakestan.kodak.dao;

import com.kodakestan.kodak.models.entities.Article;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepo extends MongoRepository<Article, ObjectId> {

}