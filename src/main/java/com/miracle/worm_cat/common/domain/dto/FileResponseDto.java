package com.miracle.worm_cat.common.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileResponseDto {

    private Long id;
    private String fileName;
    private String format;
    private String status;
    private String filePath;
    private String creator;
    private LocalDateTime upTime;

}
