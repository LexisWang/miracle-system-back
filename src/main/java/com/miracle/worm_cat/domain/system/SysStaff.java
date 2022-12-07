package com.miracle.worm_cat.domain.system;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.*;
import com.miracle.worm_cat.common.config.easy_excel.LongDateConverter;
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
    @ExcelIgnore
    @NotNull(message = "主键ID不能为空", groups = {UpdateGroup.class})
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 账号
     */
    @ExcelProperty(value = "账号")
    @NotBlank(message = "账号不能为空", groups = {AddGroup.class})
    @Length(min = 4, max = 16, message = "账号长度为4-16之间", groups = {AddGroup.class, UpdateGroup.class})
    @TableField(value = "username")
    private String username;

    /**
     * 密码
     */
    @ExcelIgnore
    @NotBlank(message = "密码不能为空")
    @Length(min = 6, max = 64, message = "密码长度为6-64之间", groups = {AddGroup.class, UpdateGroup.class})
    @TableField(value = "password")
    private String password;

    /**
     * 昵称
     */
    @ExcelProperty(value = "昵称")
    @NotBlank(message = "昵称不能为空", groups = {AddGroup.class})
    @Length(min = 2, max = 16, message = "昵称长度为4-16之间", groups = {AddGroup.class, UpdateGroup.class})
    @TableField(value = "nickname")
    private String nickname;

    /**
     * 联系邮箱
     */
    @ExcelProperty(value = "联系邮箱")
    @Length(max = 24, message = "密码长度最大为24", groups = {AddGroup.class, UpdateGroup.class})
    @TableField(value = "email")
    private String email;

    /**
     * 描述
     */
    @ExcelProperty(value = "描述")
    @Length(max = 64, message = "描述长度最大为64", groups = {AddGroup.class, UpdateGroup.class})
    @TableField(value = "remark")
    private String remark;

    /**
     * 状态
     */
    @ExcelProperty(value = "职员状态", converter = NormalStatusToString.class)
    @NotNull(message = "职员状态不能为空", groups = {AddGroup.class})
    @EnumValue(values = {-1, 0, 1}, groups = {AddGroup.class, UpdateGroup.class})
    @TableField(value = "staff_status")
    private Integer staffStatus;

    /**
     * 邀请码
     */
    @ExcelProperty(value = "邀请码")
    @Length(max = 16, message = "邀请码长度最大为16", groups = {AddGroup.class, UpdateGroup.class})
    @TableField(value = "invite_code")
    private String inviteCode;

    /**
     * 手机号
     */
    @ExcelProperty(value = "手机号")
    @Length(max = 16, message = "手机号长度最大为16", groups = {AddGroup.class, UpdateGroup.class})
    @TableField(value = "mobile")
    private String mobile;

    /**
     * 领导ID
     */
    @ExcelIgnore
    @NotNull(message = "领导ID不能为空")
    @TableField(value = "super_id")
    private Long superId;

    /**
     * 领导姓名
     * */
    @ExcelProperty(value = "领导姓名")
    @TableField(value = "super_name")
    private String superName;

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
     * 所属部门名
     */
    @ExcelProperty(value = "所属部门名")
    @Length(max = 16, message = "所有部门名最大长度为16", groups = {AddGroup.class, UpdateGroup.class})
    @TableField(value = "org_name")
    private String orgName;

    /**
     * 所属角色ID
     */
    @ExcelIgnore
    @NotNull(message = "所属角色ID不能为空", groups = {AddGroup.class})
    @TableField(value = "role_id")
    private Integer roleId;

    /**
     * 所有角色名
     */
    @ExcelProperty(value = "所属角色名")
    @NotNull(message = "所属角色名不能为空", groups = {AddGroup.class})
    @Length(max = 16, message = "所属角色名最大长度为16", groups = {AddGroup.class, UpdateGroup.class})
    @TableField(value = "role_name")
    private String roleName;

    /**
     * 权限码
     */
    @ExcelProperty(value = "权限码")
    @TableField(value = "scope_key")
    private String scopeKey;

    /**
     * 排序号
     * */
    @ExcelProperty(value = "排序号")
    @NotNull(message = "排序号不能为空", groups = {AddGroup.class})
    @TableField(value = "sort_no")
    private Long sortNo;

    /**
     * 创建时间
     */
    @ExcelProperty(value = "创建时间", converter = LongDateConverter.class)
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Long createTime;

    /**
     * 更新时间
     */
    @ExcelProperty(value = "更新时间", converter = LongDateConverter.class)
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
    @ExcelProperty(value = "创建者")
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
    @ExcelProperty(value = "修改者")
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