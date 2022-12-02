package com.miracle.worm_cat.domain.system;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.miracle.worm_cat.validate.AddGroup;
import com.miracle.worm_cat.validate.UpdateGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 按钮配置表
 * @TableName sys_button
 */
@Data
@ToString
@EqualsAndHashCode
@TableName(value ="sys_button")
public class SysButton implements Serializable {
    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = {UpdateGroup.class})
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 数字号
     */
    @NotNull(message = "按钮数字号不能为空", groups = {AddGroup.class})
    @TableField(value = "code")
    private String code;

    /**
     * 名称码
     */
    @NotBlank(message = "按钮名称码不能为空", groups = {AddGroup.class})
    @Length(min = 4, max = 32, message = "按钮名称码长度在4-32之间", groups = {AddGroup.class, UpdateGroup.class})
    @TableField(value = "name")
    private String name;

    /**
     * 所属菜单ID
     */
    @NotNull(message = "所属菜单ID不能为空", groups = {AddGroup.class})
    @TableField(value = "menu_id")
    private Integer menuId;

    /**
     * 所有所属菜单IDS
     */
    @ExcelIgnore
    @NotBlank(message = "所有所属菜单IDS不能为空", groups = {AddGroup.class})
    @TableField(value = "menu_ids")
    private String menuIds;

    @ExcelIgnore
    @TableField(value = "menu_name")
    private String menuName;

    /**
     * 所属模块号
     */
    @NotNull(message = "所属模块号不能为空", groups = {AddGroup.class})
    @TableField(value = "sort_no")
    private Integer sortNo;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}