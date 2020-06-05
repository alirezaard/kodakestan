package com.kodakestan.kodak.services;

import com.kodakestan.kodak.dao.ArticleRepo;
import com.kodakestan.kodak.models.dto.Crud;
import com.kodakestan.kodak.models.dto.input.ArticleInputDto;
import com.kodakestan.kodak.models.dto.output.ArticleOutputDto;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * @author Alireza
 * @version 1.0.0
 * @date 6.5.2020
 */
@Service
public class ArticleService implements Crud<ArticleInputDto, ArticleOutputDto> {

    @Inject
    private ArticleRepo repo;

    @Override
    public ArticleOutputDto insert(ArticleInputDto articleInputDto) {
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
}
