package com.kodakestan.kodak.models.mapper;

import com.kodakestan.kodak.models.dto.input.ArticleInputDto;
import com.kodakestan.kodak.models.entities.Article;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.io.IOException;
import java.sql.Date;

/**
 * @author Alireza
 * @version 1.0.0
 * @date 6.5.2020
 */
@Component
public class ArticleMapper {

    @Inject
    private ImageMapper imgMapper;

    public Article dtoToArticle(ArticleInputDto dto) throws IOException {
        Article article = new Article();

        article.setDate(new Date(System.currentTimeMillis()));
        article.setLike(0L);
        article.setMemories(dto.getMemories());
        article.setTags(dto.getTag());
        //article.setUuid(UUID.randomUUID().toString());
        article.setVisible(true);
        article.setOwner(dto.getOwner());
        article.setImages(imgMapper.fileToImage(dto.getImag()));

        return article;
    }
}
