package com.miracle.worm_cat.common.config.easy_excel;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.miracle.worm_cat.common.constant.BaseConstant;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;

public class LongDateConverter implements Converter<Long> {
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
        LocalDate localDate = Instant.ofEpochMilli(timestamp).atZone(ZoneOffset.ofHours(8)).toLocalDate();
        return new WriteCellData<>(localDate.format(BaseConstant.DATE_FORMATTER_HYPHEN));
    }

    @Override
    public Long convertToJavaData(ReadCellData<?> cellData, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        String dateStrValue = cellData.getStringValue();
        long timestampFromLocalDate = 0L;
        LocalDate localDate = null;
        if (dateStrValue.contains("-")) {
            localDate = LocalDate.parse(dateStrValue, BaseConstant.DATE_FORMATTER_HYPHEN);
        } else if (dateStrValue.contains("/")) {
            localDate = LocalDate.parse(dateStrValue, BaseConstant.DATE_FORMATTER_SLASH);
        }
        if (null != localDate) {
            timestampFromLocalDate = localDate.atStartOfDay().toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
        }
        return timestampFromLocalDate;
    }
}
