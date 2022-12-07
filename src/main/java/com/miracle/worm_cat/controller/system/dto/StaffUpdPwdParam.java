package com.miracle.worm_cat.controller.system.dto;

import com.miracle.worm_cat.validate.UpdateGroup;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * author: Miracle-
 * time: 2022/12/6 22:07
 */
@Data
public class StaffUpdPwdParam {
    @NotNull(message = "主键ID不能为空")
    private Long id;
    @NotBlank(message = "必须输入新密码", groups = {UpdateGroup.class})
    private String newPwd;
}
