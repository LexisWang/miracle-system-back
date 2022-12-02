package com.miracle.worm_cat.domain.system;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * 部门职员
 * @TableName sys_staff
 */
@Data
@ToString
@EqualsAndHashCode
@TableName(value ="sys_staff")
public class SysStaff implements Serializable {
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 账号
     */
    @TableField(value = "username")
    private String username;

    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 昵称
     */
    @TableField(value = "nickname")
    private String nickname;

    /**
     * 联系邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 描述
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 状态
     */
    @TableField(value = "staff_status")
    private Integer staffStatus;

    /**
     * 邀请码
     */
    @TableField(value = "invite_code")
    private String inviteCode;

    /**
     * 手机号
     */
    @TableField(value = "mobile")
    private String mobile;

    /**
     * 领导ID
     */
    @TableField(value = "super_id")
    private Long superId;

    /**
     * 所属组织ID
     */
    @TableField(value = "org_id")
    private Object orgId;

    /**
     * 所有组织名
     */
    @TableField(value = "org_name")
    private String orgName;

    /**
     * 所属角色ID
     */
    @TableField(value = "role_id")
    private Integer roleId;

    /**
     * 所有角色名
     */
    @TableField(value = "role_name")
    private String roleName;

    /**
     * 权限码
     */
    @TableField(value = "scope_key")
    private String scopeKey;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Long createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Long updateTime;

    /**
     * 创建者ID
     */
    @TableField(value = "creator_id")
    private Long creatorId;

    /**
     * 创建者名称
     */
    @TableField(value = "creator_name")
    private String creatorName;

    /**
     * 修改者ID
     */
    @TableField(value = "updater_id")
    private Long updaterId;

    /**
     * 修改者名称
     */
    @TableField(value = "updater_name")
    private String updaterName;

    /**
     * 当前版本
     */
    @Version
    @TableField(value = "version")
    private Integer version;

    /**
     * 是否逻辑删除
     */
    @TableField(value = "deleted")
    private Boolean deleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}