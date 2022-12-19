package com.miracle.worm_cat.domain.common;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 附件表
 * @TableName comm_attach
 */
@TableName(value ="comm_attach")
@Data
public class CommAttach implements Serializable {
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 关联的类型
     */
    @TableField(value = "category")
    private String category;

    /**
     * 类型号
     */
    @TableField(value = "category_int")
    private Integer categoryInt;

    /**
     * 关联的数据ID
     */
    @TableField(value = "related_id")
    private Long relatedId;

    /**
     * 文件名
     */
    @TableField(value = "file_name")
    private String fileName;

    /**
     * 文件格式
     */
    @TableField(value = "file_format")
    private String fileFormat;

    /**
     * 文件路径
     */
    @TableField(value = "file_path")
    private String filePath;

    /**
     * 上传时间
     */
    @TableField(value = "upload_time")
    private Long uploadTime;

    /**
     * 上传人
     */
    @TableField(value = "creator")
    private String creator;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

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
        CommAttach other = (CommAttach) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCategory() == null ? other.getCategory() == null : this.getCategory().equals(other.getCategory()))
            && (this.getCategoryInt() == null ? other.getCategoryInt() == null : this.getCategoryInt().equals(other.getCategoryInt()))
            && (this.getRelatedId() == null ? other.getRelatedId() == null : this.getRelatedId().equals(other.getRelatedId()))
            && (this.getFileName() == null ? other.getFileName() == null : this.getFileName().equals(other.getFileName()))
            && (this.getFileFormat() == null ? other.getFileFormat() == null : this.getFileFormat().equals(other.getFileFormat()))
            && (this.getFilePath() == null ? other.getFilePath() == null : this.getFilePath().equals(other.getFilePath()))
            && (this.getUploadTime() == null ? other.getUploadTime() == null : this.getUploadTime().equals(other.getUploadTime()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCategory() == null) ? 0 : getCategory().hashCode());
        result = prime * result + ((getCategoryInt() == null) ? 0 : getCategoryInt().hashCode());
        result = prime * result + ((getRelatedId() == null) ? 0 : getRelatedId().hashCode());
        result = prime * result + ((getFileName() == null) ? 0 : getFileName().hashCode());
        result = prime * result + ((getFileFormat() == null) ? 0 : getFileFormat().hashCode());
        result = prime * result + ((getFilePath() == null) ? 0 : getFilePath().hashCode());
        result = prime * result + ((getUploadTime() == null) ? 0 : getUploadTime().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", category=").append(category);
        sb.append(", categoryInt=").append(categoryInt);
        sb.append(", relatedId=").append(relatedId);
        sb.append(", fileName=").append(fileName);
        sb.append(", fileFormat=").append(fileFormat);
        sb.append(", filePath=").append(filePath);
        sb.append(", uploadTime=").append(uploadTime);
        sb.append(", creator=").append(creator);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}