package com.miracle.worm_cat.common.utils;

import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtil {

    public static String Md5Encrypt(String dataStr) {
        DigestUtils.md5DigestAsHex(dataStr.getBytes(StandardCharsets.UTF_8));
        return DigestUtils.md5DigestAsHex(dataStr.getBytes(StandardCharsets.UTF_8));
    }

    public static String Sha1Encrypt(String dataStr) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(dataStr.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte b : result) {
            sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}
