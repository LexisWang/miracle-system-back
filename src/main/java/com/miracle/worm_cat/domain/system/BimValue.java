package com.miracle.worm_cat.domain.system;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;

/**
 * 配置字典值
 * @TableName bim_value
 */
@TableName(value ="bim_value")
public class BimValue implements Serializable {
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Object id;

    /**
     * 代码
     */
    @TableField(value = "value_code")
    private String valueCode;

    /**
     * 名称
     */
    @TableField(value = "value_name")
    private String valueName;

    /**
     * 状态
     */
    @TableField(value = "value_status")
    private Integer valueStatus;

    /**
     * 包含的子ID
     */
    @TableField(value = "include_ids")
    private String includeIds;

    /**
     * 所属类别名
     */
    @TableField(value = "belong_name")
    private String belongName;

    /**
     * 所属类别ID
     */
    @TableField(value = "super_id")
    private Object superId;

    /**
     * 字典类ID
     */
    @TableField(value = "dict_id")
    private Integer dictId;

    /**
     * 字典类名
     */
    @TableField(value = "dict_name")
    private String dictName;

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
    public Object getId() {
        return id;
    }

    /**
     * 主键ID
     */
    public void setId(Object id) {
        this.id = id;
    }

    /**
     * 代码
     */
    public String getValueCode() {
        return valueCode;
    }

    /**
     * 代码
     */
    public void setValueCode(String valueCode) {
        this.valueCode = valueCode;
    }

    /**
     * 名称
     */
    public String getValueName() {
        return valueName;
    }

    /**
     * 名称
     */
    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    /**
     * 状态
     */
    public Integer getValueStatus() {
        return valueStatus;
    }

    /**
     * 状态
     */
    public void setValueStatus(Integer valueStatus) {
        this.valueStatus = valueStatus;
    }

    /**
     * 包含的子ID
     */
    public String getIncludeIds() {
        return includeIds;
    }

    /**
     * 包含的子ID
     */
    public void setIncludeIds(String includeIds) {
        this.includeIds = includeIds;
    }

    /**
     * 所属类别名
     */
    public String getBelongName() {
        return belongName;
    }

    /**
     * 所属类别名
     */
    public void setBelongName(String belongName) {
        this.belongName = belongName;
    }

    /**
     * 所属类别ID
     */
    public Object getSuperId() {
        return superId;
    }

    /**
     * 所属类别ID
     */
    public void setSuperId(Object superId) {
        this.superId = superId;
    }

    /**
     * 字典类ID
     */
    public Integer getDictId() {
        return dictId;
    }

    /**
     * 字典类ID
     */
    public void setDictId(Integer dictId) {
        this.dictId = dictId;
    }

    /**
     * 字典类名
     */
    public String getDictName() {
        return dictName;
    }

    /**
     * 字典类名
     */
    public void setDictName(String dictName) {
        this.dictName = dictName;
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
        BimValue other = (BimValue) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getValueCode() == null ? other.getValueCode() == null : this.getValueCode().equals(other.getValueCode()))
            && (this.getValueName() == null ? other.getValueName() == null : this.getValueName().equals(other.getValueName()))
            && (this.getValueStatus() == null ? other.getValueStatus() == null : this.getValueStatus().equals(other.getValueStatus()))
            && (this.getIncludeIds() == null ? other.getIncludeIds() == null : this.getIncludeIds().equals(other.getIncludeIds()))
            && (this.getBelongName() == null ? other.getBelongName() == null : this.getBelongName().equals(other.getBelongName()))
            && (this.getSuperId() == null ? other.getSuperId() == null : this.getSuperId().equals(other.getSuperId()))
            && (this.getDictId() == null ? other.getDictId() == null : this.getDictId().equals(other.getDictId()))
            && (this.getDictName() == null ? other.getDictName() == null : this.getDictName().equals(other.getDictName()))
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
        result = prime * result + ((getValueCode() == null) ? 0 : getValueCode().hashCode());
        result = prime * result + ((getValueName() == null) ? 0 : getValueName().hashCode());
        result = prime * result + ((getValueStatus() == null) ? 0 : getValueStatus().hashCode());
        result = prime * result + ((getIncludeIds() == null) ? 0 : getIncludeIds().hashCode());
        result = prime * result + ((getBelongName() == null) ? 0 : getBelongName().hashCode());
        result = prime * result + ((getSuperId() == null) ? 0 : getSuperId().hashCode());
        result = prime * result + ((getDictId() == null) ? 0 : getDictId().hashCode());
        result = prime * result + ((getDictName() == null) ? 0 : getDictName().hashCode());
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
        sb.append(", valueCode=").append(valueCode);
        sb.append(", valueName=").append(valueName);
        sb.append(", valueStatus=").append(valueStatus);
        sb.append(", includeIds=").append(includeIds);
        sb.append(", belongName=").append(belongName);
        sb.append(", superId=").append(superId);
        sb.append(", dictId=").append(dictId);
        sb.append(", dictName=").append(dictName);
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