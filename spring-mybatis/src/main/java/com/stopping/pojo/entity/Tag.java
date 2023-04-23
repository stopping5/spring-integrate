package com.stopping.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 多选标签表
 * </p>
 *
 * @author ideamake
 * @date 2023-04-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("im_tag")
public class Tag implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 值
     */
    @TableField(value = "`value`")
    private String value;

    /**
     * 表头字段名称
     */
    @TableField(value = "`key`")
    private String key;

    private String groupCode;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    /**
     * 标签状态（0失效，1生效）
     */
    @TableField(value = "`status`")
    private Integer status;

    /**
     * 备注
     */
    private String remark;


}
