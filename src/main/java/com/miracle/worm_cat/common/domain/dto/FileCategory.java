package com.miracle.worm_cat.common.domain.dto;


import com.miracle.worm_cat.common.constant.BaseConstant;
import com.miracle.worm_cat.common.exception.MiracleException;

public enum FileCategory {
    CONSIGNOR(10, "consignor"),
    CONSIGNOR_GRADE(15, "consignorGrade"),
    NORMAL_ORDER(20, "normalOrder"),
    NORMAL_FREIGHT(21, "normalFreight"),
    ORDER_SIGN(30, "normalOrderSign"),
    ORDER_FUND_SETTLE(40, "orderFundSettle"),
    ORDER_FUND_DISSENT(45, "orderFundDissent"),
    FREIGHT_FUND_SETTLE(50, "freightFundSettle"),
    MIDDLE_FUND_SETTLE(60, "middleFundSettle"),
    DECLARE_FUND_SETTLE(70, "declareFundSettle"),
    CUSTOMS_FUND_SETTLE(80, "customsFundSettle"),
    GOODS_DELIVERY(90, "goodsDelivery"),
    SALES_APPLY_SITE_CUSTOMER(100, "timeoutApply");

    private final Integer categoryNumber;
    private final String categoryName;

    FileCategory(Integer categoryNumber, String categoryName) {
        this.categoryNumber = categoryNumber;
        this.categoryName = categoryName;
    }

    public Integer getCategoryNumber() {
        return categoryNumber;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public static Integer getNumberByName(String categoryName) {
        switch (categoryName) {
            case "consignor":
                return CONSIGNOR.getCategoryNumber();
            case "consignorGrade":
                return CONSIGNOR_GRADE.getCategoryNumber();
            case "normalOrder":
                return NORMAL_ORDER.getCategoryNumber();
            case "normalFreight":
                return NORMAL_FREIGHT.getCategoryNumber();
            case "normalOrderSign":
                return ORDER_SIGN.getCategoryNumber();
            case "orderFundSettle":
                return ORDER_FUND_SETTLE.getCategoryNumber();
            case "orderFundDissent":
                return ORDER_FUND_DISSENT.getCategoryNumber();
            case "freightFundSettle":
                return FREIGHT_FUND_SETTLE.getCategoryNumber();
            case "middleFundSettle":
                return MIDDLE_FUND_SETTLE.getCategoryNumber();
            case "declareFundSettle":
                return DECLARE_FUND_SETTLE.getCategoryNumber();
            case "customsFundSettle":
                return CUSTOMS_FUND_SETTLE.getCategoryNumber();
            case "goodsDelivery":
                return GOODS_DELIVERY.getCategoryNumber();
            case "timeoutApply":
                return SALES_APPLY_SITE_CUSTOMER.getCategoryNumber();
            default:
                throw new MiracleException(BaseConstant.RESPONSE_CODE_FAILURE, "This categoryName is not exist");
        }
    }
}
