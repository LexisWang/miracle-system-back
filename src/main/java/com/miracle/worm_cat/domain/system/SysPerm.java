package com.miracle.worm_cat.domain.system;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;

/**
 * 权限表
 * @TableName sys_perm
 */
@TableName(value ="sys_perm")
public class SysPerm implements Serializable {
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 代码
     */
    @TableField(value = "perm_code")
    private String permCode;

    /**
     * 名称
     */
    @TableField(value = "perm_name")
    private String permName;

    /**
     * 路径uri
     */
    @TableField(value = "perm_uri")
    private String permUri;

    /**
     * 状态
     */
    @TableField(value = "perm_status")
    private Integer permStatus;

    /**
     * 是否叶子
     */
    @TableField(value = "is_leaf")
    private Boolean isLeaf;

    /**
     * 排序号
     */
    @TableField(value = "sort_no")
    private Integer sortNo;

    /**
     * 层级
     */
    @TableField(value = "tier_level")
    private Integer tierLevel;

    /**
     * 唯一序号(紧凑)
     */
    @TableField(value = "global_sort")
    private Long globalSort;

    /**
     * 父级ID
     */
    @TableField(value = "p_id")
    private Object pId;

    /**
     * 所有父级ID
     */
    @TableField(value = "p_ids")
    private String pIds;

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
     * 代码
     */
    public String getPermCode() {
        return permCode;
    }

    /**
     * 代码
     */
    public void setPermCode(String permCode) {
        this.permCode = permCode;
    }

    /**
     * 名称
     */
    public String getPermName() {
        return permName;
    }

    /**
     * 名称
     */
    public void setPermName(String permName) {
        this.permName = permName;
    }

    /**
     * 路径uri
     */
    public String getPermUri() {
        return permUri;
    }

    /**
     * 路径uri
     */
    public void setPermUri(String permUri) {
        this.permUri = permUri;
    }

    /**
     * 状态
     */
    public Integer getPermStatus() {
        return permStatus;
    }

    /**
     * 状态
     */
    public void setPermStatus(Integer permStatus) {
        this.permStatus = permStatus;
    }

    /**
     * 是否叶子
     */
    public Boolean getIsLeaf() {
        return isLeaf;
    }

    /**
     * 是否叶子
     */
    public void setIsLeaf(Boolean isLeaf) {
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
     * 层级
     */
    public Integer getTierLevel() {
        return tierLevel;
    }

    /**
     * 层级
     */
    public void setTierLevel(Integer tierLevel) {
        this.tierLevel = tierLevel;
    }

    /**
     * 唯一序号(紧凑)
     */
    public Long getGlobalSort() {
        return globalSort;
    }

    /**
     * 唯一序号(紧凑)
     */
    public void setGlobalSort(Long globalSort) {
        this.globalSort = globalSort;
    }

    /**
     * 父级ID
     */
    public Object getpId() {
        return pId;
    }

    /**
     * 父级ID
     */
    public void setpId(Object pId) {
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
        SysPerm other = (SysPerm) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPermCode() == null ? other.getPermCode() == null : this.getPermCode().equals(other.getPermCode()))
            && (this.getPermName() == null ? other.getPermName() == null : this.getPermName().equals(other.getPermName()))
            && (this.getPermUri() == null ? other.getPermUri() == null : this.getPermUri().equals(other.getPermUri()))
            && (this.getPermStatus() == null ? other.getPermStatus() == null : this.getPermStatus().equals(other.getPermStatus()))
            && (this.getIsLeaf() == null ? other.getIsLeaf() == null : this.getIsLeaf().equals(other.getIsLeaf()))
            && (this.getSortNo() == null ? other.getSortNo() == null : this.getSortNo().equals(other.getSortNo()))
            && (this.getTierLevel() == null ? other.getTierLevel() == null : this.getTierLevel().equals(other.getTierLevel()))
            && (this.getGlobalSort() == null ? other.getGlobalSort() == null : this.getGlobalSort().equals(other.getGlobalSort()))
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
        result = prime * result + ((getPermCode() == null) ? 0 : getPermCode().hashCode());
        result = prime * result + ((getPermName() == null) ? 0 : getPermName().hashCode());
        result = prime * result + ((getPermUri() == null) ? 0 : getPermUri().hashCode());
        result = prime * result + ((getPermStatus() == null) ? 0 : getPermStatus().hashCode());
        result = prime * result + ((getIsLeaf() == null) ? 0 : getIsLeaf().hashCode());
        result = prime * result + ((getSortNo() == null) ? 0 : getSortNo().hashCode());
        result = prime * result + ((getTierLevel() == null) ? 0 : getTierLevel().hashCode());
        result = prime * result + ((getGlobalSort() == null) ? 0 : getGlobalSort().hashCode());
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
        sb.append(", permCode=").append(permCode);
        sb.append(", permName=").append(permName);
        sb.append(", permUri=").append(permUri);
        sb.append(", permStatus=").append(permStatus);
        sb.append(", isLeaf=").append(isLeaf);
        sb.append(", sortNo=").append(sortNo);
        sb.append(", tierLevel=").append(tierLevel);
        sb.append(", globalSort=").append(globalSort);
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