package com.kodakestan.kodak.models.dto.output;

import com.kodakestan.kodak.models.dto.ImageDto;
import com.kodakestan.kodak.models.dto.input.ArticleInputDto;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author Alireza
 * @version 1.0.0
 * @date 6.5.2020
 */
@Data
public class ArticleOutputDto {
    private String uuid;
    private Date date;
    private List<ImageOutputDto> imag;
    private String memories;
    private List<String> tag;
    private String owner;
    private Long like;
    private boolean visible;
}
