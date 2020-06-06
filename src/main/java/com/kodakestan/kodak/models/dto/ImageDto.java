package com.kodakestan.kodak.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Alireza
 * @version 1.0.0
 * date 6.5.2020
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageDto {
    private MultipartFile file;
}
