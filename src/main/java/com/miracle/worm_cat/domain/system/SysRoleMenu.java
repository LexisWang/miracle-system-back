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
 * 角色菜单(中间表)
 * @TableName sys_role_menu
 */
@Data
@ToString
@EqualsAndHashCode
@TableName(value ="sys_role_menu")
public class SysRoleMenu implements Serializable {
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
     * 菜单ID
     */
    @TableField(value = "menu_id")
    private Integer menuId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}