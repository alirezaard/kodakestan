package com.kodakestan.kodak.models.dto.output;

import lombok.Data;

import java.util.List;

@Data
public class ChildrenOutputDto {
    private String uuid;
    private String name;
    private Long birthday;
    private List<ImageOutputDto> images;
    private String parentUUID;
}
