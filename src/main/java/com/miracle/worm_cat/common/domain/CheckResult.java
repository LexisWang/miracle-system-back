package com.miracle.worm_cat.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CheckResult {
    private Boolean ok;
    private String msg;
}
