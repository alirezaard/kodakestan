package com.kodakestan.kodak.models.dto.output;

import com.kodakestan.kodak.models.dto.input.ArticleInputDto;
import lombok.Data;

import java.util.Date;

@Data
public class ArticleOutputDto extends ArticleInputDto {
    private String uuid;
    private Date date;
}
