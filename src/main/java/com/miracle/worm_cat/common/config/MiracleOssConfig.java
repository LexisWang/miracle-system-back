package com.miracle.worm_cat.common.config;

import com.miracle.worm_cat.common.utils.AlibabaOssUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 注册阿里云OOS工具组件
 */
@Configuration
public class MiracleOssConfig {

    @Value("${oss.access-key-id}")
    private String accessKeyId;
    @Value("${oss.access-key-secret}")
    private String accessKeySecret;
    @Value("${oss.endpoint}")
    private String endpoint;
    @Value("${oss.oss-bucket-name}")
    private String ossBucketName;

    @Bean
    public AlibabaOssUtil ossUtil() {
        return new AlibabaOssUtil(accessKeyId, accessKeySecret, endpoint, ossBucketName);
    }
}

