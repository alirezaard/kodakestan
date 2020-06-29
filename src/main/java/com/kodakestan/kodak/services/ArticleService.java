package com.kodakestan.kodak.services;

import com.kodakestan.kodak.dao.ArticleRepo;
import com.kodakestan.kodak.models.dto.Crud;
import com.kodakestan.kodak.models.dto.input.ArticleInputDto;
import com.kodakestan.kodak.models.dto.output.ArticleOutputDto;
import com.kodakestan.kodak.models.entities.Image;
import com.kodakestan.kodak.models.mapper.ArticleMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * @author Alireza
 * @version 1.0.0
 * date 6.5.2020
 */
@Service
@Transactional(isolation = Isolation.SERIALIZABLE)
public class ArticleService implements Crud<ArticleInputDto, ArticleOutputDto> {

    @Inject
    private ArticleRepo repo;

    @Inject
    private ArticleMapper mapper;

    @Override
    public ArticleOutputDto find(String uuid) {
        return null;
    }

    @Override
    public ArticleOutputDto insert(ArticleInputDto inoutDto) {
        return null;
    }

    @Override
    public void delete(ArticleInputDto articleInputDto) {

    }

    @Override
    public List<ArticleInputDto> getAll() {
        return null;
    }

    @Override
    public ArticleOutputDto edit(ArticleInputDto articleInputDto) {
        return null;
    }

    @Override
    public List<ArticleInputDto> deleteAll() {
        return null;
    }

    @Override
    public ArticleOutputDto addImage(Image img) {
        return null;
    }
}
