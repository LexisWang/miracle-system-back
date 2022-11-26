package com.miracle.worm_cat.common.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class ExportRespUtil {

    public static void setResponseHeader(String fileName, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setContentType("application/vnd.ms-excel");
        response.addHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.addHeader("charset", "utf-8");
        String encodeName = URLEncoder.encode(fileName, StandardCharsets.UTF_8.toString());
        response.addHeader("Pragma", "no-cache;filename=" + encodeName);
    }

}
