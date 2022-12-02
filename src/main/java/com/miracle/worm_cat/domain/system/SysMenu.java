package com.miracle.worm_cat.domain.system;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.*;
import com.miracle.worm_cat.common.config.easy_excel.LongDateConverter;
import com.miracle.worm_cat.common.config.easy_excel.NormalBinaryToString;
import com.miracle.worm_cat.common.config.easy_excel.NormalStatusToString;
import com.miracle.worm_cat.validate.AddGroup;
import com.miracle.worm_cat.validate.EnumValue;
import com.miracle.worm_cat.validate.UpdateGroup;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 菜单表
 * @TableName sys_menu
 */
@TableName(value ="sys_menu")
public class SysMenu implements Serializable {
    /**
     * 主键ID
     */
    @ExcelIgnore
    @NotNull(message = "主键ID不能为空", groups = {UpdateGroup.class})
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 代码
     */
    @ExcelProperty(value = "菜单代码", index = 0)
    @NotBlank(message = "菜单代码不能为空", groups = {AddGroup.class})
    @Length(min = 4, max = 16, message = "菜单代码长度在4-16之间", groups = {AddGroup.class, UpdateGroup.class})
    @TableField(value = "menu_code")
    private String menuCode;

    /**
     * 名称
     */
    @ExcelProperty(value = "菜单名称", index = 1)
    @NotBlank(message = "菜单名称不能为空", groups = {AddGroup.class})
    @Length(min = 4, max = 16, message = "菜单名称度在4-16之间", groups = {AddGroup.class, UpdateGroup.class})
    @TableField(value = "menu_name")
    private String menuName;

    /**
     * 路由url
     */
    @ExcelProperty(value = "菜单路径", index = 2)
    @NotBlank(message = "菜单路径不能为空", groups = {AddGroup.class})
    @Length(max = 64, message = "菜单路径长度不能超过64", groups = {AddGroup.class, UpdateGroup.class})
    @TableField(value = "menu_url")
    private String menuUrl;

    /**
     * 图标
     */
    @ExcelIgnore
    @Length(max = 64, message = "图标长度不能超过64", groups = {AddGroup.class, UpdateGroup.class})
    @TableField(value = "menu_icon")
    private String menuIcon;

    /**
     * 状态
     */
    @ExcelProperty(value = "菜单状态", index = 3, converter = NormalStatusToString.class)
    @NotNull(message = "菜单状态不能为空", groups = {AddGroup.class})
    @EnumValue(values = {-1, 0, 1}, groups = {AddGroup.class, UpdateGroup.class})
    @TableField(value = "menu_status")
    private Integer menuStatus;

    /**
     * 是否叶子
     */
    @ExcelProperty(value = "是否叶子", index = 4, converter = NormalBinaryToString.class)
    @NotNull(message = "是否叶子不能为空", groups = {AddGroup.class})
    @EnumValue(values = {0, 1}, groups = {AddGroup.class, UpdateGroup.class})
    @TableField(value = "is_leaf")
    private Integer isLeaf;

    /**
     * 排序号
     */
    @ExcelProperty(value = "排序号", index = 5)
    @NotNull(message = "排序号不能为空", groups = {AddGroup.class})
    @TableField(value = "sort_no")
    private Integer sortNo;

    /**
     * 层级
     */
    @ExcelProperty(value = "权限等级", index = 6)
    @NotNull(message = "权限等级不能为空", groups = {AddGroup.class})
    @TableField(value = "tier_level")
    private Integer tierLevel;

    /**
     * 唯一序号(紧凑)
     */
    @ExcelIgnore
    @TableField(value = "global_sort")
    private Integer globalSort;

    /**
     * 父级ID
     */
    @ExcelIgnore
    @NotNull(message = "父级ID不能为空", groups = {AddGroup.class})
    @TableField(value = "p_id")
    private Integer pId;

    /**
     * 所有父级ID
     */
    @ExcelIgnore
    @NotBlank(message = "所有父级ID不能为空", groups = {AddGroup.class})
    @TableField(value = "p_ids")
    private String pIds;

    /**
     * 备注信息
     */
    @ExcelProperty(value = "备注信息", index = 7)
    @Length(max = 100, message = "备注信息长度不能超过100", groups = {AddGroup.class, UpdateGroup.class})
    @TableField(value = "menu_remark")
    private String menuRemark;

    /**
     * 创建时间
     */
    @ExcelProperty(value = "创建时间", index = 8, converter = LongDateConverter.class)
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Long createTime;

    /**
     * 更新时间
     */
    @ExcelProperty(value = "更新时间", index = 9, converter = LongDateConverter.class)
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Long updateTime;

    /**
     * 创建者ID
     */
    @ExcelIgnore
    @TableField(value = "creator_id")
    private Long creatorId;

    /**
     * 创建者名称
     */
    @ExcelProperty(value = "创建者", index = 10)
    @TableField(value = "creator_name")
    private String creatorName;

    /**
     * 修改者ID
     */
    @ExcelIgnore
    @TableField(value = "updater_id")
    private Long updaterId;

    /**
     * 修改者名称
     */
    @ExcelProperty(value = "修改者", index = 11)
    @TableField(value = "updater_name")
    private String updaterName;

    /**
     * 当前版本
     */
    @ExcelIgnore
    @Version
    @TableField(value = "version")
    private Integer version;

    /**
     * 是否逻辑删除
     */
    @ExcelIgnore
    @EnumValue(values = {0, 1}, groups = {UpdateGroup.class})
    @TableField(value = "deleted")
    private Integer deleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public Integer getMenuStatus() {
        return menuStatus;
    }

    public void setMenuStatus(Integer menuStatus) {
        this.menuStatus = menuStatus;
    }

    public Integer getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Integer isLeaf) {
        this.isLeaf = isLeaf;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    public Integer getTierLevel() {
        return tierLevel;
    }

    public void setTierLevel(Integer tierLevel) {
        this.tierLevel = tierLevel;
    }

    public Integer getGlobalSort() {
        return globalSort;
    }

    public void setGlobalSort(Integer globalSort) {
        this.globalSort = globalSort;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpIds() {
        return pIds;
    }

    public void setpIds(String pIds) {
        this.pIds = pIds;
    }

    public String getMenuRemark() {
        return menuRemark;
    }

    public void setMenuRemark(String menuRemark) {
        this.menuRemark = menuRemark;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public Long getUpdaterId() {
        return updaterId;
    }

    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    public String getUpdaterName() {
        return updaterName;
    }

    public void setUpdaterName(String updaterName) {
        this.updaterName = updaterName;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getDeleted() {
        return deleted;
    }

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
        SysMenu other = (SysMenu) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMenuCode() == null ? other.getMenuCode() == null : this.getMenuCode().equals(other.getMenuCode()))
            && (this.getMenuName() == null ? other.getMenuName() == null : this.getMenuName().equals(other.getMenuName()))
            && (this.getMenuUrl() == null ? other.getMenuUrl() == null : this.getMenuUrl().equals(other.getMenuUrl()))
            && (this.getMenuIcon() == null ? other.getMenuIcon() == null : this.getMenuIcon().equals(other.getMenuIcon()))
            && (this.getMenuStatus() == null ? other.getMenuStatus() == null : this.getMenuStatus().equals(other.getMenuStatus()))
            && (this.getIsLeaf() == null ? other.getIsLeaf() == null : this.getIsLeaf().equals(other.getIsLeaf()))
            && (this.getSortNo() == null ? other.getSortNo() == null : this.getSortNo().equals(other.getSortNo()))
            && (this.getTierLevel() == null ? other.getTierLevel() == null : this.getTierLevel().equals(other.getTierLevel()))
            && (this.getGlobalSort() == null ? other.getGlobalSort() == null : this.getGlobalSort().equals(other.getGlobalSort()))
            && (this.getpId() == null ? other.getpId() == null : this.getpId().equals(other.getpId()))
            && (this.getpIds() == null ? other.getpIds() == null : this.getpIds().equals(other.getpIds()))
            && (this.getMenuRemark() == null ? other.getMenuRemark() == null : this.getMenuRemark().equals(other.getMenuRemark()))
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
        result = prime * result + ((getMenuCode() == null) ? 0 : getMenuCode().hashCode());
        result = prime * result + ((getMenuName() == null) ? 0 : getMenuName().hashCode());
        result = prime * result + ((getMenuUrl() == null) ? 0 : getMenuUrl().hashCode());
        result = prime * result + ((getMenuIcon() == null) ? 0 : getMenuIcon().hashCode());
        result = prime * result + ((getMenuStatus() == null) ? 0 : getMenuStatus().hashCode());
        result = prime * result + ((getIsLeaf() == null) ? 0 : getIsLeaf().hashCode());
        result = prime * result + ((getSortNo() == null) ? 0 : getSortNo().hashCode());
        result = prime * result + ((getTierLevel() == null) ? 0 : getTierLevel().hashCode());
        result = prime * result + ((getGlobalSort() == null) ? 0 : getGlobalSort().hashCode());
        result = prime * result + ((getpId() == null) ? 0 : getpId().hashCode());
        result = prime * result + ((getpIds() == null) ? 0 : getpIds().hashCode());
        result = prime * result + ((getMenuRemark() == null) ? 0 : getMenuRemark().hashCode());
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
        sb.append(", menuCode=").append(menuCode);
        sb.append(", menuName=").append(menuName);
        sb.append(", menuUrl=").append(menuUrl);
        sb.append(", menuIcon=").append(menuIcon);
        sb.append(", menuStatus=").append(menuStatus);
        sb.append(", isLeaf=").append(isLeaf);
        sb.append(", sortNo=").append(sortNo);
        sb.append(", tierLevel=").append(tierLevel);
        sb.append(", globalSort=").append(globalSort);
        sb.append(", pId=").append(pId);
        sb.append(", pIds=").append(pIds);
        sb.append(", menuRemark=").append(menuRemark);
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