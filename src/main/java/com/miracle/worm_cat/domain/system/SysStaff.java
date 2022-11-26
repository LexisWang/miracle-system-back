package com.miracle.worm_cat.domain.system;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;

/**
 * 部门职员
 * @TableName sys_staff
 */
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
    private Object roleId;

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

    /**
     * 主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 账号
     */
    public String getUsername() {
        return username;
    }

    /**
     * 账号
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 联系邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 联系邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 描述
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 描述
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 状态
     */
    public Integer getStaffStatus() {
        return staffStatus;
    }

    /**
     * 状态
     */
    public void setStaffStatus(Integer staffStatus) {
        this.staffStatus = staffStatus;
    }

    /**
     * 邀请码
     */
    public String getInviteCode() {
        return inviteCode;
    }

    /**
     * 邀请码
     */
    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    /**
     * 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 领导ID
     */
    public Long getSuperId() {
        return superId;
    }

    /**
     * 领导ID
     */
    public void setSuperId(Long superId) {
        this.superId = superId;
    }

    /**
     * 所属组织ID
     */
    public Object getOrgId() {
        return orgId;
    }

    /**
     * 所属组织ID
     */
    public void setOrgId(Object orgId) {
        this.orgId = orgId;
    }

    /**
     * 所有组织名
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * 所有组织名
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
     * 所属角色ID
     */
    public Object getRoleId() {
        return roleId;
    }

    /**
     * 所属角色ID
     */
    public void setRoleId(Object roleId) {
        this.roleId = roleId;
    }

    /**
     * 所有角色名
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 所有角色名
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 权限码
     */
    public String getScopeKey() {
        return scopeKey;
    }

    /**
     * 权限码
     */
    public void setScopeKey(String scopeKey) {
        this.scopeKey = scopeKey;
    }

    /**
     * 创建时间
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新时间
     */
    public Long getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     */
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 创建者ID
     */
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     * 创建者ID
     */
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 创建者名称
     */
    public String getCreatorName() {
        return creatorName;
    }

    /**
     * 创建者名称
     */
    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    /**
     * 修改者ID
     */
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     * 修改者ID
     */
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * 修改者名称
     */
    public String getUpdaterName() {
        return updaterName;
    }

    /**
     * 修改者名称
     */
    public void setUpdaterName(String updaterName) {
        this.updaterName = updaterName;
    }

    /**
     * 当前版本
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 当前版本
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * 是否逻辑删除
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * 是否逻辑删除
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysStaff other = (SysStaff) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getStaffStatus() == null ? other.getStaffStatus() == null : this.getStaffStatus().equals(other.getStaffStatus()))
            && (this.getInviteCode() == null ? other.getInviteCode() == null : this.getInviteCode().equals(other.getInviteCode()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getSuperId() == null ? other.getSuperId() == null : this.getSuperId().equals(other.getSuperId()))
            && (this.getOrgId() == null ? other.getOrgId() == null : this.getOrgId().equals(other.getOrgId()))
            && (this.getOrgName() == null ? other.getOrgName() == null : this.getOrgName().equals(other.getOrgName()))
            && (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
            && (this.getRoleName() == null ? other.getRoleName() == null : this.getRoleName().equals(other.getRoleName()))
            && (this.getScopeKey() == null ? other.getScopeKey() == null : this.getScopeKey().equals(other.getScopeKey()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreatorId() == null ? other.getCreatorId() == null : this.getCreatorId().equals(other.getCreatorId()))
            && (this.getCreatorName() == null ? other.getCreatorName() == null : this.getCreatorName().equals(other.getCreatorName()))
            && (this.getUpdaterId() == null ? other.getUpdaterId() == null : this.getUpdaterId().equals(other.getUpdaterId()))
            && (this.getUpdaterName() == null ? other.getUpdaterName() == null : this.getUpdaterName().equals(other.getUpdaterName()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getStaffStatus() == null) ? 0 : getStaffStatus().hashCode());
        result = prime * result + ((getInviteCode() == null) ? 0 : getInviteCode().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getSuperId() == null) ? 0 : getSuperId().hashCode());
        result = prime * result + ((getOrgId() == null) ? 0 : getOrgId().hashCode());
        result = prime * result + ((getOrgName() == null) ? 0 : getOrgName().hashCode());
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        result = prime * result + ((getRoleName() == null) ? 0 : getRoleName().hashCode());
        result = prime * result + ((getScopeKey() == null) ? 0 : getScopeKey().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreatorId() == null) ? 0 : getCreatorId().hashCode());
        result = prime * result + ((getCreatorName() == null) ? 0 : getCreatorName().hashCode());
        result = prime * result + ((getUpdaterId() == null) ? 0 : getUpdaterId().hashCode());
        result = prime * result + ((getUpdaterName() == null) ? 0 : getUpdaterName().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", nickname=").append(nickname);
        sb.append(", email=").append(email);
        sb.append(", remark=").append(remark);
        sb.append(", staffStatus=").append(staffStatus);
        sb.append(", inviteCode=").append(inviteCode);
        sb.append(", mobile=").append(mobile);
        sb.append(", superId=").append(superId);
        sb.append(", orgId=").append(orgId);
        sb.append(", orgName=").append(orgName);
        sb.append(", roleId=").append(roleId);
        sb.append(", roleName=").append(roleName);
        sb.append(", scopeKey=").append(scopeKey);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", creatorId=").append(creatorId);
        sb.append(", creatorName=").append(creatorName);
        sb.append(", updaterId=").append(updaterId);
        sb.append(", updaterName=").append(updaterName);
        sb.append(", version=").append(version);
        sb.append(", deleted=").append(deleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}