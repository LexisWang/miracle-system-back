package com.miracle.worm_cat.excel_listener.system;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.miracle.worm_cat.domain.system.SysOrg;

import java.util.ArrayList;
import java.util.List;

/**
 * author: Miracle-
 * time: 2022/11/27 14:31
 */
public class SysOrgExcelListener extends AnalysisEventListener<SysOrg> {

    public List<SysOrg> orgList = new ArrayList<>();

    @Override
    public void invoke(SysOrg org, AnalysisContext analysisContext) {
        orgList.add(org);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("读取部门组织表格结束: " + analysisContext);
    }
}
