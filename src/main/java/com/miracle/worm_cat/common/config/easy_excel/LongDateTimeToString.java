package com.miracle.worm_cat.common.config.easy_excel;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import org.joda.time.LocalDateTime;

public class LongDateTimeToString implements Converter<Long> {
    @Override
    public Class<?> supportJavaTypeKey() {
        return Long.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public WriteCellData<?> convertToExcelData(Long timestamp, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) {
        LocalDateTime dateTime = new LocalDateTime(timestamp);
        return new WriteCellData<>(dateTime.toString("yyyy-MM-dd HH:mm:ss"));
    }
}
