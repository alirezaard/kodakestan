package com.kodakestan.kodak.models.dto.output;

import com.kodakestan.kodak.models.dto.input.ArticleInputDto;
import lombok.Data;

import java.util.Date;

/**
 * @author Alireza
 * @version 1.0.0
 * @date 6.5.2020
 */
@Data
public class ArticleOutputDto extends ArticleInputDto {
    private String uuid;
    private Date date;
}
