package com.miracle.worm_cat.common.config.easy_excel;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.miracle.worm_cat.common.domain.NormalStatus;
import org.joda.time.LocalDate;

public class NormalStatusToString implements Converter<Integer> {
    @Override
    public Class<?> supportJavaTypeKey() {
        return Long.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public WriteCellData<?> convertToExcelData(Integer normalStatus, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) {
        return new WriteCellData<>(NormalStatus.getLabelByValue(normalStatus));
    }
}
