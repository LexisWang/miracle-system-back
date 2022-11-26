package com.miracle.worm_cat.domain.system;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 定时任务
 * @TableName bim_task
 */
@TableName(value ="bim_task")
public class BimTask implements Serializable {
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Object id;

    /**
     * 业务ID
     */
    @TableField(value = "job_id")
    private String jobId;

    /**
     * 业务名
     */
    @TableField(value = "job_name")
    private String jobName;

    /**
     * 业务参数
     */
    @TableField(value = "job_params")
    private String jobParams;

    /**
     * 业务分组
     */
    @TableField(value = "job_group")
    private String jobGroup;

    /**
     * 任务ID
     */
    @TableField(value = "task_id")
    private Object taskId;

    /**
     * 任务数量
     */
    @TableField(value = "task_count")
    private Object taskCount;

    /**
     * 任务运行次数
     */
    @TableField(value = "run_count")
    private Object runCount;

    /**
     * 回调目标
     */
    @TableField(value = "invoke_target")
    private String invokeTarget;

    /**
     * cron表达式
     */
    @TableField(value = "cron_expression")
    private String cronExpression;

    /**
     * 不奏效策略
     */
    @TableField(value = "misfire_policy")
    private String misfirePolicy;

    /**
     * 是否并发
     */
    @TableField(value = "concurrent")
    private Boolean concurrent;

    /**
     * 任务状态
     */
    @TableField(value = "status")
    private String status;

    /**
     * 上次运行时间
     */
    @TableField(value = "last_time")
    private LocalDateTime lastTime;

    /**
     * 下次运行时间
     */
    @TableField(value = "next_time")
    private LocalDateTime nextTime;

    /**
     * 彻底结束时间
     */
    @TableField(value = "end_time")
    private LocalDateTime endTime;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField(value = "update_time")
    private LocalDateTime updateTime;

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
     * 业务ID
     */
    public String getJobId() {
        return jobId;
    }

    /**
     * 业务ID
     */
    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    /**
     * 业务名
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * 业务名
     */
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    /**
     * 业务参数
     */
    public String getJobParams() {
        return jobParams;
    }

    /**
     * 业务参数
     */
    public void setJobParams(String jobParams) {
        this.jobParams = jobParams;
    }

    /**
     * 业务分组
     */
    public String getJobGroup() {
        return jobGroup;
    }

    /**
     * 业务分组
     */
    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    /**
     * 任务ID
     */
    public Object getTaskId() {
        return taskId;
    }

    /**
     * 任务ID
     */
    public void setTaskId(Object taskId) {
        this.taskId = taskId;
    }

    /**
     * 任务数量
     */
    public Object getTaskCount() {
        return taskCount;
    }

    /**
     * 任务数量
     */
    public void setTaskCount(Object taskCount) {
        this.taskCount = taskCount;
    }

    /**
     * 任务运行次数
     */
    public Object getRunCount() {
        return runCount;
    }

    /**
     * 任务运行次数
     */
    public void setRunCount(Object runCount) {
        this.runCount = runCount;
    }

    /**
     * 回调目标
     */
    public String getInvokeTarget() {
        return invokeTarget;
    }

    /**
     * 回调目标
     */
    public void setInvokeTarget(String invokeTarget) {
        this.invokeTarget = invokeTarget;
    }

    /**
     * cron表达式
     */
    public String getCronExpression() {
        return cronExpression;
    }

    /**
     * cron表达式
     */
    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    /**
     * 不奏效策略
     */
    public String getMisfirePolicy() {
        return misfirePolicy;
    }

    /**
     * 不奏效策略
     */
    public void setMisfirePolicy(String misfirePolicy) {
        this.misfirePolicy = misfirePolicy;
    }

    /**
     * 是否并发
     */
    public Boolean getConcurrent() {
        return concurrent;
    }

    /**
     * 是否并发
     */
    public void setConcurrent(Boolean concurrent) {
        this.concurrent = concurrent;
    }

    /**
     * 任务状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 任务状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 上次运行时间
     */
    public LocalDateTime getLastTime() {
        return lastTime;
    }

    /**
     * 上次运行时间
     */
    public void setLastTime(LocalDateTime lastTime) {
        this.lastTime = lastTime;
    }

    /**
     * 下次运行时间
     */
    public LocalDateTime getNextTime() {
        return nextTime;
    }

    /**
     * 下次运行时间
     */
    public void setNextTime(LocalDateTime nextTime) {
        this.nextTime = nextTime;
    }

    /**
     * 彻底结束时间
     */
    public LocalDateTime getEndTime() {
        return endTime;
    }

    /**
     * 彻底结束时间
     */
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    /**
     * 创建时间
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改时间
     */
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     */
    public void setUpdateTime(LocalDateTime updateTime) {
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
        BimTask other = (BimTask) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getJobId() == null ? other.getJobId() == null : this.getJobId().equals(other.getJobId()))
            && (this.getJobName() == null ? other.getJobName() == null : this.getJobName().equals(other.getJobName()))
            && (this.getJobParams() == null ? other.getJobParams() == null : this.getJobParams().equals(other.getJobParams()))
            && (this.getJobGroup() == null ? other.getJobGroup() == null : this.getJobGroup().equals(other.getJobGroup()))
            && (this.getTaskId() == null ? other.getTaskId() == null : this.getTaskId().equals(other.getTaskId()))
            && (this.getTaskCount() == null ? other.getTaskCount() == null : this.getTaskCount().equals(other.getTaskCount()))
            && (this.getRunCount() == null ? other.getRunCount() == null : this.getRunCount().equals(other.getRunCount()))
            && (this.getInvokeTarget() == null ? other.getInvokeTarget() == null : this.getInvokeTarget().equals(other.getInvokeTarget()))
            && (this.getCronExpression() == null ? other.getCronExpression() == null : this.getCronExpression().equals(other.getCronExpression()))
            && (this.getMisfirePolicy() == null ? other.getMisfirePolicy() == null : this.getMisfirePolicy().equals(other.getMisfirePolicy()))
            && (this.getConcurrent() == null ? other.getConcurrent() == null : this.getConcurrent().equals(other.getConcurrent()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLastTime() == null ? other.getLastTime() == null : this.getLastTime().equals(other.getLastTime()))
            && (this.getNextTime() == null ? other.getNextTime() == null : this.getNextTime().equals(other.getNextTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
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
        result = prime * result + ((getJobId() == null) ? 0 : getJobId().hashCode());
        result = prime * result + ((getJobName() == null) ? 0 : getJobName().hashCode());
        result = prime * result + ((getJobParams() == null) ? 0 : getJobParams().hashCode());
        result = prime * result + ((getJobGroup() == null) ? 0 : getJobGroup().hashCode());
        result = prime * result + ((getTaskId() == null) ? 0 : getTaskId().hashCode());
        result = prime * result + ((getTaskCount() == null) ? 0 : getTaskCount().hashCode());
        result = prime * result + ((getRunCount() == null) ? 0 : getRunCount().hashCode());
        result = prime * result + ((getInvokeTarget() == null) ? 0 : getInvokeTarget().hashCode());
        result = prime * result + ((getCronExpression() == null) ? 0 : getCronExpression().hashCode());
        result = prime * result + ((getMisfirePolicy() == null) ? 0 : getMisfirePolicy().hashCode());
        result = prime * result + ((getConcurrent() == null) ? 0 : getConcurrent().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastTime() == null) ? 0 : getLastTime().hashCode());
        result = prime * result + ((getNextTime() == null) ? 0 : getNextTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
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
        sb.append(", jobId=").append(jobId);
        sb.append(", jobName=").append(jobName);
        sb.append(", jobParams=").append(jobParams);
        sb.append(", jobGroup=").append(jobGroup);
        sb.append(", taskId=").append(taskId);
        sb.append(", taskCount=").append(taskCount);
        sb.append(", runCount=").append(runCount);
        sb.append(", invokeTarget=").append(invokeTarget);
        sb.append(", cronExpression=").append(cronExpression);
        sb.append(", misfirePolicy=").append(misfirePolicy);
        sb.append(", concurrent=").append(concurrent);
        sb.append(", status=").append(status);
        sb.append(", lastTime=").append(lastTime);
        sb.append(", nextTime=").append(nextTime);
        sb.append(", endTime=").append(endTime);
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