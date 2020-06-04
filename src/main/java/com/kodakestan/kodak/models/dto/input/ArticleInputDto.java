package com.kodakestan.kodak.models.dto.input;

import com.kodakestan.kodak.models.dto.ImageDto;
import lombok.Data;

import java.util.List;

@Data
public class ArticleInputDto {
    private List<ImageDto> imag;
    private String memories;
    private List<String> tag;
    private String owner;
    private Long like;
    private boolean visible;
}