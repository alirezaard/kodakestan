package com.kodakestan.kodak.models.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Alireza
 * @version 1.0.0
 * @date 6.5.2020
 */
@Data
public class ImageDto {
    private MultipartFile file;
}
