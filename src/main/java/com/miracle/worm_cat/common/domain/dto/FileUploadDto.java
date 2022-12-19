package com.miracle.worm_cat.common.domain.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class FileUploadDto {
    private MultipartFile file;
    private String category;
    private Long relatedId;
    private String relatedIds;
}
