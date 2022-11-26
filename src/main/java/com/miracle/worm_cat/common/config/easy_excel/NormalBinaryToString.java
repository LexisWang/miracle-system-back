package com.miracle.worm_cat.common.config.easy_excel;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.miracle.worm_cat.common.domain.NormalBinary;
import com.miracle.worm_cat.common.domain.NormalStatus;

public class NormalBinaryToString implements Converter<Integer> {
    @Override
    public Class<?> supportJavaTypeKey() {
        return Long.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public WriteCellData<?> convertToExcelData(Integer normalBinary, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) {
        return new WriteCellData<>(NormalBinary.getLabelByValue(normalBinary));
    }
}
