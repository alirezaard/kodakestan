package com.kodakestan.kodak.models.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
//todo fix this...
public class ImageDto {
    private List<MultipartFile> file;
}
