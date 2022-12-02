package com.miracle.worm_cat.domain.system;

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

import javax.validation.constraints.NotNull;

/**
 * 角色权限(中间表)
 * @TableName sys_role_perm
 */
@Data
@ToString
@EqualsAndHashCode
@TableName(value ="sys_role_perm")
public class SysRolePerm implements Serializable {
    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = {UpdateGroup.class})
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色ID
     */
    @NotNull(message = "角色ID不能为空", groups = {UpdateGroup.class})
    @TableField(value = "role_id")
    private Integer roleId;

    /**
     * 权限ID
     */
    @NotNull(message = "权限ID不能为空", groups = {UpdateGroup.class})
    @TableField(value = "perm_Id")
    private Integer permId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}