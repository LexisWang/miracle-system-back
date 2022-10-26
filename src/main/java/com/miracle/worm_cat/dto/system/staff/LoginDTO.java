package com.miracle.worm_cat.dto.system.staff;

import com.miracle.worm_cat.validate.AddGroup;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * author: Miracle-
 * time: 2022/10/26 22:32
 */
@Data
public class LoginDTO {

    @NotBlank(message = "用户名不能为空", groups = AddGroup.class)
    @Length(min = 6, max = 24, message = "用户名长度在6-24之间", groups = AddGroup.class)
    private String username;

    @NotBlank(message = "密码不能为空", groups = AddGroup.class)
    @Length(min = 6, max = 64, message = "密码长度在6-64之间", groups = AddGroup.class)
    private String password;

}
