package com.miracle.worm_cat.domain.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 角色按钮(中间表)
 * @TableName sys_role_button
 */
@Data
@ToString
@EqualsAndHashCode
@TableName(value ="sys_role_button")
public class SysRoleButton implements Serializable {
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色ID
     */
    @TableField(value = "role_id")
    private Integer roleId;

    /**
     * 按钮ID
     */
    @TableField(value = "button_id")
    private Integer buttonId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}