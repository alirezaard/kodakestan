package com.kodakestan.kodak.models.mapper;

import com.kodakestan.kodak.models.dto.input.ArticleInputDto;
import com.kodakestan.kodak.models.entities.Article;

import java.sql.Date;
import java.util.UUID;

public class ArticleMapper {
    public static Article dtoToArticle(ArticleInputDto dto) {
        Article article = new Article();

        article.setDate(new Date(System.currentTimeMillis()));
        article.setLike(0L);
        article.setMemories(dto.getMemories());
        article.setTags(dto.getTag());
        //article.setUuid(UUID.randomUUID().toString());
        article.setVisible(true);
        article.setOwner(dto.getOwner());
        article.setImages();

        return article;
    }
}
