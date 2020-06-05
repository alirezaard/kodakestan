package com.kodakestan.kodak.models.dto.input;

import com.kodakestan.kodak.models.dto.ImageDto;
import lombok.Data;

import java.util.List;

@Data
public class ChildrenInputDto {
    private String name;
    private Long birthday;
    private List<ImageDto> images;
    private String parentUUID;
}
