package com.miracle.worm_cat.common.config.easy_excel;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.miracle.worm_cat.common.constant.BaseConstant;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class LongDateTimeConverter implements Converter<Long> {
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
        LocalDateTime localDateTime = Instant.ofEpochMilli(timestamp).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
        return new WriteCellData<>(localDateTime.format(BaseConstant.DATE_TIME_FORMATTER_HYPHEN));
    }

    @Override
    public Long convertToJavaData(ReadCellData<?> cellData, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        String datetimeStrValue = cellData.getStringValue();
        long timestampFromLocalDatetime = 0L;
        LocalDateTime localDateTime = null;
        if (datetimeStrValue.contains("-")) {
            localDateTime = LocalDateTime.parse(datetimeStrValue, BaseConstant.DATE_TIME_FORMATTER_HYPHEN);
        } else if (datetimeStrValue.contains("/")) {
            localDateTime = LocalDateTime.parse(datetimeStrValue, BaseConstant.DATE_TIME_FORMATTER_SLASH);
        }
        if (null != localDateTime) {
            timestampFromLocalDatetime = localDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
        }
        return timestampFromLocalDatetime;
    }
}
