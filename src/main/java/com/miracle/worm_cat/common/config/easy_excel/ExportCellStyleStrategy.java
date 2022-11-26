package com.miracle.worm_cat.common.config.easy_excel;

import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;

public class ExportCellStyleStrategy {

    public static HorizontalCellStyleStrategy getStyleStrategy() {
        WriteCellStyle headStyle = new WriteCellStyle();
        // 1. 垂直居中，水平居中
        headStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        headStyle.setHorizontalAlignment(HorizontalAlignment.LEFT);
        headStyle.setBorderLeft(BorderStyle.THIN);
        headStyle.setBorderTop(BorderStyle.THIN);
        headStyle.setBorderRight(BorderStyle.THIN);
        headStyle.setBorderBottom(BorderStyle.THIN);
        // 2. 不设置自动换行
        headStyle.setWrapped(false);
        // 3. 字体策略
        WriteFont writeFont = new WriteFont();
        writeFont.setFontHeightInPoints((short) 12);
        headStyle.setWriteFont(writeFont);

        return new HorizontalCellStyleStrategy(headStyle, (WriteCellStyle) null);
    }
}
