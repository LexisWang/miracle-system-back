package com.miracle.worm_cat.dto;

/**
 * @Null 被注释的元素必须为null
 *
 * @NotNull 被注释的元素不能为null
 *
 * @AssertTrue 被注释的元素必须为true
 *
 * @AssertFalse 被注释的元素必须为false
 *
 * @Min(value) 被注释的元素必须是一个数字，其值必须大于等于指定的最小值
 *
 * @Max(value) 被注释的元素必须是一个数字，其值必须小于等于指定的最大值
 *
 * @DecimalMin(value) 被注释的元素必须是一个数字，其值必须大于等于指定的最小值
 *
 * @DecimalMax(value) 被注释的元素必须是一个数字，其值必须小于等于指定的最大值
 *
 * @Size(max,min) 被注释的元素的大小必须在指定的范围内。
 *
 * @Digits(integer,fraction) 被注释的元素必须是一个数字，其值必须在可接受的范围内
 *
 * @Past 被注释的元素必须是一个过去的日期
 *
 * @Future 被注释的元素必须是一个将来的日期
 *
 * @Pattern(value) 被注释的元素必须符合指定的正则表达式。
 *
 * @Email 被注释的元素必须是电子邮件地址
 *
 * @Length 被注释的字符串的大小必须在指定的范围内
 *
 * @NotEmpty 被注释的字符串必须非空
 *
 * @Range 被注释的元素必须在合适的范围内
 *
 * example:  String name = " ";
 *           @NotNull: true
 *           @NotEmpty: true
 *           @NotBlank: false
 * */

import com.miracle.worm_cat.validate.AddGroup;
import com.miracle.worm_cat.validate.EnumValue;
import com.miracle.worm_cat.validate.PhoneValue;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

/**
 * author: Miracle-
 * time: 2022/10/25 22:27
 */
@Data
public class UserDTO {

    private Integer id;

    @NotBlank(message = "用户名不能为空", groups = AddGroup.class)
    @Length(min = 6, max = 24, message = "用户名长度在6-24之间", groups = AddGroup.class)
    private String username;

    @NotBlank(message = "密码不能为空", groups = AddGroup.class)
    @Length(min = 6, max = 24, message = "密码长度在6-24之间", groups = AddGroup.class)
    private String password;

    @Email(message = "邮箱格式不正确")
    private String email;

    @Pattern(regexp = "^(\\d{18}|\\d{15}|\\d{17}[x|X]})$", message = "身份证格式错误")
    private String idCard;

    @NotNull(message = "状态码不能为空", groups = AddGroup.class)
    @EnumValue(values = {1, 2, 3, 4}, groups = AddGroup.class)
    private Integer status;

    @PhoneValue(groups = {AddGroup.class})
    private String phoneNumber;

}
