package com.miracle.worm_cat.controller.common;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miracle.worm_cat.common.constant.BaseConstant;
import com.miracle.worm_cat.common.domain.JwtUserInfo;
import com.miracle.worm_cat.common.domain.dto.FileCategory;
import com.miracle.worm_cat.common.domain.dto.FileResponseDto;
import com.miracle.worm_cat.common.domain.dto.FileUploadDto;
import com.miracle.worm_cat.common.exception.MiracleException;
import com.miracle.worm_cat.common.response.RespResult;
import com.miracle.worm_cat.common.response.ResultCode;
import com.miracle.worm_cat.common.utils.AlibabaOssUtil;
import com.miracle.worm_cat.domain.common.CommAttach;
import com.miracle.worm_cat.service.common.CommAttachService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * author: Miracle-
 * time: 2022/12/19 9:48
 */
@RestController
@RequestMapping(value = "/common-mgr/comm-attachment")
public class AttachmentController {

    @Resource
    private AlibabaOssUtil ossUtil;

    @Resource
    private CommAttachService attachService;

    @Value(value = "${oss.domain-name}")
    private String ossDomainName;

    /**
     * 带关联ID的上传
     */
    @PostMapping(value = "uploadByRelatedId")
    public RespResult<?> uploadByRelatedId(FileUploadDto uploadDto, HttpServletRequest request) throws IOException {
        JwtUserInfo reqUser = (JwtUserInfo) request.getAttribute(BaseConstant.REQUEST_USER);
        MultipartFile file = uploadDto.getFile();
        String category = uploadDto.getCategory();
        Long relatedId = uploadDto.getRelatedId();
        String relatedIds = uploadDto.getRelatedIds();

        if (StringUtils.isBlank(category)) {
            return RespResult.failure("category is error!");
        }
        if (null == relatedId && StringUtils.isBlank(relatedIds)) {
            return RespResult.failure("relatedId or relatedIds is required");
        }
        String originalFilename = file.getOriginalFilename();
        String filename = originalFilename;
        if (!StringUtils.isBlank(originalFilename)) {
            String[] splitRes = originalFilename.split("\\.");
            if (originalFilename.length() > 16) {
                filename = originalFilename.substring(0, 11) + "..." + "." + splitRes[splitRes.length - 1];;
            }
            //1.1 获取文件格式
            String fileFormat = splitRes[splitRes.length - 1];
            //1.2 获取文件输入流
            InputStream inputStream = file.getInputStream();
            // .3 上传文件流
            String fileDir = category + "/" + LocalDate.now();
            try {
                String uniqueFileName = ossUtil.uploadFile(fileDir, inputStream, fileFormat);
                if (null != uniqueFileName) {
                    String fullFileUrl = ossDomainName.concat(uniqueFileName);
                    Long attachmentId = null;
                    ObjectMapper objectMapper = new ObjectMapper();
                    List<Long> relateIdsArr = (List<Long>) objectMapper.readValue("[" + relatedIds + "]", List.class);
                    //1.4 把数据存储到数据库中
                    if (null != relatedId && relatedId > 0) {
                        relateIdsArr = Collections.singletonList(relatedId);
                    }
                    String finalFilename = filename;
                    List<CommAttach> attachments = relateIdsArr.stream().map(item -> {
                        CommAttach attachment = new CommAttach();
                        attachment.setCategory(category);
                        attachment.setCategoryInt(FileCategory.getNumberByName(category));
                        attachment.setRelatedId(item);
                        attachment.setFileName(finalFilename);
                        attachment.setFileFormat(fileFormat);
                        attachment.setFilePath(fullFileUrl);
                        attachment.setUploadTime(LocalDateTime.now().toInstant(ZoneOffset.ofHours(8)).toEpochMilli());
                        attachment.setCreator(reqUser.getNickname());
                        return attachment;
                    }).collect(Collectors.toList());
                    attachService.saveBatch(attachments);

                    //1.5 封装数据返回给前端
                    FileResponseDto fileResDto = new FileResponseDto();
                    fileResDto.setId(attachmentId);
                    fileResDto.setFileName(filename);
                    fileResDto.setFormat(fileFormat);
                    fileResDto.setStatus("done");
                    fileResDto.setFilePath(fullFileUrl);
                    fileResDto.setCreator(reqUser.getNickname());

                    return RespResult.success();
                }
                return RespResult.failure(originalFilename + "fileName is error!");
            } catch (Exception e) {
                throw new MiracleException(ResultCode.FAILURE.getCode(), filename + e.getMessage());
            }
        } else {
            return RespResult.failure(ResultCode.VALIDATE_FAILED.getCode(), filename + "Filename is None");
        }
    }

    /**
     * 获取附件列表
     */
    @PostMapping(value = "attachmentList")
    public RespResult<?> attachmentList(@RequestBody FileUploadDto uploadDto, HttpServletRequest request) {
        String category = uploadDto.getCategory();
        Long relatedId = uploadDto.getRelatedId();
        if (StringUtils.isBlank(category) || null == relatedId) {
            return RespResult.failure("expected more param");
        }
        LambdaQueryWrapper<CommAttach> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CommAttach::getCategoryInt, FileCategory.getNumberByName(category))
                .eq(CommAttach::getRelatedId, relatedId);
        List<CommAttach> attachments = attachService.list(wrapper);
        return RespResult.success(attachments);
    }

    /**
     * 删除附件
     */
    @DeleteMapping(value = "deleteAttachment")
    public RespResult<?> deleteAttachment(@RequestBody CommAttach attachment) {
        if (null == attachment || null == attachment.getId() || StringUtils.isBlank(attachment.getFilePath())) {
            return RespResult.failure("expected more param");
        }

        try {
            //1.删除OSS中的附件
            ossUtil.deleteFile(attachment.getFilePath().replace(ossDomainName, ""));
            //2.删除mysql中的数据
            attachService.removeById(attachment.getId());
        } catch (Exception e) {
            return RespResult.failure(e.getMessage());
        }

        return RespResult.success();
    }

}
