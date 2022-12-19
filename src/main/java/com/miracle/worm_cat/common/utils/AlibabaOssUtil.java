package com.miracle.worm_cat.common.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.PutObjectResult;
import lombok.Getter;

import java.io.InputStream;

@Getter
public class AlibabaOssUtil {

    String accessKeyId;
    String accessKeySecret;
    String endpoint;
    String ossBucketName;
    private final OSS oss;

    public AlibabaOssUtil(String accessKeyId, String accessKeySecret, String endpoint, String ossBucketName) {
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
        this.endpoint = endpoint;
        this.ossBucketName = ossBucketName;
        this.oss = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
    }

    /**
     * 上传附件方法
     * */
    public String uploadFile(String fileDir, InputStream initialFile, String fileFormat) {
        String uniqueFileName = fileDir.concat("/").concat(String.valueOf(System.nanoTime())).concat(".").concat(fileFormat);
        PutObjectResult res = oss.putObject(ossBucketName, uniqueFileName, initialFile);
        if (res != null) { return uniqueFileName; }
        return null;
    }

    /**
     * 获取附件
     * */
    public OSSObject downloadFile(String uniqueFileName) {
        return oss.getObject(ossBucketName, uniqueFileName);
    }

    /**
     * 删除附件
     */
    public void deleteFile(String uniqueFileName) {
        oss.deleteObject(ossBucketName, uniqueFileName);
    }
}
