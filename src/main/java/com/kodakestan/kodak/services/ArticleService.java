package com.kodakestan.kodak.services;

import com.kodakestan.kodak.dao.ArticleRepo;
import com.kodakestan.kodak.models.dto.Crud;
import com.kodakestan.kodak.models.dto.input.ArticleInputDto;
import com.kodakestan.kodak.models.dto.output.ArticleOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
