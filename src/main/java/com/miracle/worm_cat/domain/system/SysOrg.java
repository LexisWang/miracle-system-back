package com.miracle.worm_cat.domain.system;

import com.baomidou.mybatisplus.annotation.*;
import com.miracle.worm_cat.validate.AddGroup;
import com.miracle.worm_cat.validate.EnumValue;
import com.miracle.worm_cat.validate.UpdateGroup;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 部门组织
 * @TableName sys_org
 */
@TableName(value ="sys_org")
public class SysOrg implements Serializable {
    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = {UpdateGroup.class})
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 代码
     */
    @NotBlank(message = "部门代码不能为空", groups = {AddGroup.class})
    @Length(min = 4, max = 16, message = "部门代码长度在4-16之间", groups = {AddGroup.class, UpdateGroup.class})
    @TableField(value = "org_code")
    private String orgCode;

    /**
     * 名称
     */
    @NotBlank(message = "部门名称不能为空", groups = {AddGroup.class})
    @Length(min = 4, max = 16, message = "部门名称度在4-16之间", groups = {AddGroup.class, UpdateGroup.class})
    @TableField(value = "org_name")
    private String orgName;

    /**
     * 描述
     */
    @Length(max = 64, message = "部门描述长度不能超过64", groups = {AddGroup.class, UpdateGroup.class})
    @TableField(value = "org_desc")
    private String orgDesc;

    /**
     * 联系地址
     */
    @Length(max = 64, message = "部门联系地址长度不能超过64", groups = {AddGroup.class, UpdateGroup.class})
    @TableField(value = "address")
    private String address;

    /**
     * 联系方式
     */
    @Length(max = 64, message = "部门联系方式长度不能超过64", groups = {AddGroup.class, UpdateGroup.class})
    @TableField(value = "contact")
    private String contact;

    /**
     * 联系邮箱
     */
    @Length(max = 24, message = "部门联系邮箱长度不能超过24", groups = {AddGroup.class, UpdateGroup.class})
    @TableField(value = "email")
    private String email;

    /**
     * 状态
     */
    @NotNull(message = "部门状态不能为空", groups = {AddGroup.class})
    @EnumValue(values = {-1, 0, 1}, groups = {AddGroup.class, UpdateGroup.class})
    @TableField(value = "org_status")
    private Integer orgStatus;

    /**
     * 是否叶子
     */
    @NotNull(message = "是否叶子不能为空", groups = {AddGroup.class})
    @EnumValue(values = {0, 1}, groups = {AddGroup.class, UpdateGroup.class})
    @TableField(value = "is_leaf")
    private Integer isLeaf;

    /**
     * 排序号
     */
    @NotNull(message = "排序号不能为空", groups = {AddGroup.class})
    @TableField(value = "sort_no")
    private Integer sortNo;

    /**
     * 权限码
     */
    @Length(max = 32, message = "权限码长度不能超过32", groups = {AddGroup.class, UpdateGroup.class})
    @TableField(value = "scope_key")
    private String scopeKey;

    /**
     * 权限等级
     */
    @NotNull(message = "权限等级不能为空", groups = {AddGroup.class})
    @TableField(value = "tier_level")
    private Integer tierLevel;

    /**
     * 父级ID
     */
    @NotNull(message = "父级ID不能为空", groups = {AddGroup.class})
    @TableField(value = "p_id")
    private Integer pId;

    /**
     * 所有父级ID
     */
    @NotBlank(message = "所有父级ID不能为空", groups = {AddGroup.class})
    @TableField(value = "p_ids")
    private String pIds;

    /**
     * 备注信息
     */
    @Length(max = 100, message = "备注信息长度不能超过100", groups = {AddGroup.class, UpdateGroup.class})
    @TableField(value = "org_remark")
    private String orgRemark;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Long createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
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
    @EnumValue(values = {0, 1}, groups = {UpdateGroup.class})
    @TableField(value = "deleted")
    private Integer deleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 代码
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * 代码
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    /**
     * 名称
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * 名称
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
     * 描述
     */
    public String getOrgDesc() {
        return orgDesc;
    }

    /**
     * 描述
     */
    public void setOrgDesc(String orgDesc) {
        this.orgDesc = orgDesc;
    }

    /**
     * 联系地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 联系地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 联系方式
     */
    public String getContact() {
        return contact;
    }

    /**
     * 联系方式
     */
    public void setContact(String contact) {
        this.contact = contact;
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
     * 状态
     */
    public Integer getOrgStatus() {
        return orgStatus;
    }

    /**
     * 状态
     */
    public void setOrgStatus(Integer orgStatus) {
        this.orgStatus = orgStatus;
    }

    /**
     * 是否叶子
     */
    public Integer getIsLeaf() {
        return isLeaf;
    }

    /**
     * 是否叶子
     */
    public void setIsLeaf(Integer isLeaf) {
        this.isLeaf = isLeaf;
    }

    /**
     * 排序号
     */
    public Integer getSortNo() {
        return sortNo;
    }

    /**
     * 排序号
     */
    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
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
     * 权限等级
     */
    public Integer getTierLevel() {
        return tierLevel;
    }

    /**
     * 权限等级
     */
    public void setTierLevel(Integer tierLevel) {
        this.tierLevel = tierLevel;
    }

    /**
     * 父级ID
     */
    public Integer getpId() {
        return pId;
    }

    /**
     * 父级ID
     */
    public void setpId(Integer pId) {
        this.pId = pId;
    }

    /**
     * 所有父级ID
     */
    public String getpIds() {
        return pIds;
    }

    /**
     * 所有父级ID
     */
    public void setpIds(String pIds) {
        this.pIds = pIds;
    }

    public String getOrgRemark() {
        return orgRemark;
    }

    public void setOrgRemark(String orgRemark) {
        this.orgRemark = orgRemark;
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
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * 是否逻辑删除
     */
    public void setDeleted(Integer deleted) {
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
        SysOrg other = (SysOrg) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrgCode() == null ? other.getOrgCode() == null : this.getOrgCode().equals(other.getOrgCode()))
            && (this.getOrgName() == null ? other.getOrgName() == null : this.getOrgName().equals(other.getOrgName()))
            && (this.getOrgDesc() == null ? other.getOrgDesc() == null : this.getOrgDesc().equals(other.getOrgDesc()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getContact() == null ? other.getContact() == null : this.getContact().equals(other.getContact()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getOrgStatus() == null ? other.getOrgStatus() == null : this.getOrgStatus().equals(other.getOrgStatus()))
            && (this.getIsLeaf() == null ? other.getIsLeaf() == null : this.getIsLeaf().equals(other.getIsLeaf()))
            && (this.getSortNo() == null ? other.getSortNo() == null : this.getSortNo().equals(other.getSortNo()))
            && (this.getScopeKey() == null ? other.getScopeKey() == null : this.getScopeKey().equals(other.getScopeKey()))
            && (this.getTierLevel() == null ? other.getTierLevel() == null : this.getTierLevel().equals(other.getTierLevel()))
            && (this.getpId() == null ? other.getpId() == null : this.getpId().equals(other.getpId()))
            && (this.getpIds() == null ? other.getpIds() == null : this.getpIds().equals(other.getpIds()))
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
        result = prime * result + ((getOrgCode() == null) ? 0 : getOrgCode().hashCode());
        result = prime * result + ((getOrgName() == null) ? 0 : getOrgName().hashCode());
        result = prime * result + ((getOrgDesc() == null) ? 0 : getOrgDesc().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getContact() == null) ? 0 : getContact().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getOrgStatus() == null) ? 0 : getOrgStatus().hashCode());
        result = prime * result + ((getIsLeaf() == null) ? 0 : getIsLeaf().hashCode());
        result = prime * result + ((getSortNo() == null) ? 0 : getSortNo().hashCode());
        result = prime * result + ((getScopeKey() == null) ? 0 : getScopeKey().hashCode());
        result = prime * result + ((getTierLevel() == null) ? 0 : getTierLevel().hashCode());
        result = prime * result + ((getpId() == null) ? 0 : getpId().hashCode());
        result = prime * result + ((getpIds() == null) ? 0 : getpIds().hashCode());
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
        sb.append(", orgCode=").append(orgCode);
        sb.append(", orgName=").append(orgName);
        sb.append(", orgDesc=").append(orgDesc);
        sb.append(", address=").append(address);
        sb.append(", contact=").append(contact);
        sb.append(", email=").append(email);
        sb.append(", orgStatus=").append(orgStatus);
        sb.append(", isLeaf=").append(isLeaf);
        sb.append(", sortNo=").append(sortNo);
        sb.append(", scopeKey=").append(scopeKey);
        sb.append(", tierLevel=").append(tierLevel);
        sb.append(", pId=").append(pId);
        sb.append(", pIds=").append(pIds);
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