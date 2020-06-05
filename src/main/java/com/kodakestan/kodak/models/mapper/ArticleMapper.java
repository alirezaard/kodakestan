package com.kodakestan.kodak.models.mapper;

import com.kodakestan.kodak.models.dto.input.ArticleInputDto;
import com.kodakestan.kodak.models.dto.output.ArticleOutputDto;
import com.kodakestan.kodak.models.dto.output.ImageOutputDto;
import com.kodakestan.kodak.models.entities.Article;
import com.kodakestan.kodak.models.entities.Image;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

        article.setDate(System.currentTimeMillis());
        article.setLike(0L);
        article.setMemories(dto.getMemories());
        article.setTags(dto.getTag());
        //article.setUuid(UUID.randomUUID().toString());
        article.setVisible(true);
        article.setOwner(dto.getOwner());
        article.setImages(imgMapper.fileToImage(dto.getImag()));

        return article;
    }

    public ArticleOutputDto articleToDto(Article article) throws IOException {
        ArticleOutputDto dto = new ArticleOutputDto();

        dto.setDate(new Date(article.getDate()));
        dto.setUuid(article.getUuid());
        dto.setVisible(article.isVisible());
        dto.setMemories(article.getMemories());
        dto.setOwner(article.getOwner());
        dto.setTag(article.getTags());
        dto.setLike(article.getLike());
        List<Image> images = article.getImages();
        ArrayList<ImageOutputDto> imageList = new ArrayList<>();
        if (images != null && !images.isEmpty()) {
            for (Image img : images) {
                ImageOutputDto imgOutPut = imgMapper.imageToDto(img.getId());
                imageList.add(imgOutPut);
            }
        }
        dto.setImag(imageList);


        return dto;
    }
}
