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
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 部门角色
 * @TableName sys_role
 */
@Data
@ToString
@EqualsAndHashCode
@TableName(value ="sys_role")
public class SysRole implements Serializable {
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
    @ExcelProperty(value = "角色代码", index = 0)
    @NotBlank(message = "角色代码不能为空", groups = {AddGroup.class})
    @Length(min = 4, max = 16, message = "角色代码长度在4-16之间", groups = {AddGroup.class, UpdateGroup.class})
    @TableField(value = "role_code")
    private String roleCode;

    /**
     * 名称
     */
    @ExcelProperty(value = "角色名称", index = 1)
    @NotBlank(message = "角色名称不能为空", groups = {AddGroup.class})
    @Length(min = 4, max = 16, message = "角色名称度在4-16之间", groups = {AddGroup.class, UpdateGroup.class})
    @TableField(value = "role_name")
    private String roleName;

    /**
     * 描述
     */
    @ExcelProperty(value = "角色描述", index = 2)
    @Length(max = 64, message = "角色描述长度不能超过64", groups = {AddGroup.class, UpdateGroup.class})
    @TableField(value = "role_desc")
    private String roleDesc;

    /**
     * 状态
     */
    @ExcelProperty(value = "角色状态", index = 3, converter = NormalStatusToString.class)
    @NotNull(message = "角色状态不能为空", groups = {AddGroup.class})
    @EnumValue(values = {-1, 0, 1}, groups = {AddGroup.class, UpdateGroup.class})
    @TableField(value = "role_status")
    private Integer roleStatus;

    /**
     * 是否叶子
     */
    @ExcelProperty(value = "是否叶子", index = 4, converter = NormalBinaryToString.class)
    @NotNull(message = "是否叶子不能为空", groups = {AddGroup.class, UpdateGroup.class})
    @EnumValue(values = {0, 1}, groups = {AddGroup.class, UpdateGroup.class})
    @TableField(value = "is_leaf")
    private Integer isLeaf;

    /**
     * 排序号
     */
    @ExcelProperty(value = "排序号", index = 5)
    @NotNull(message = "排序号不能为空", groups = {AddGroup.class, UpdateGroup.class})
    @TableField(value = "sort_no")
    private Integer sortNo;

    /**
     * 权限码
     */
    @ExcelProperty(value = "权限码", index = 6)
    @TableField(value = "scope_key")
    private String scopeKey;

    /**
     * 所属组织ID
     */
    @ExcelIgnore
    @NotNull(message = "所属组织ID不能为空", groups = {AddGroup.class})
    @TableField(value = "org_id")
    private Integer orgId;

    /**
     * 所属组所有织ID
     */
    @ExcelIgnore
    @NotBlank(message = "所属组所有织ID不能为空", groups = {AddGroup.class})
    @TableField(value = "org_ids")
    private String orgIds;

    /**
     * 所有组织名
     */
    @ExcelProperty(value = "所有组织名", index = 7)
    @TableField(value = "org_name")
    private String orgName;

    /**
     * 备注信息
     */
    @ExcelProperty(value = "备注信息", index = 11)
    @Length(max = 100, message = "备注信息长度不能超过100", groups = {AddGroup.class, UpdateGroup.class})
    @TableField(value = "role_remark")
    private String roleRemark;

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
}