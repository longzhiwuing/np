package com.cecdat.np.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * st_ecological_dataset 

2018年6月28日 星期四【新增】
 * </p>
 *
 * @author chenzhongyong@cecdat.com
 * @since 2018-06-28
 */
@Data
@TableName("st_ecological_dataset")
public class StEcologicalDataset implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
    @TableField
    private Integer sequenceNo;
    /**
     * 医院名称
     */
    @TableField
    private String medicalOrgName;
    /**
     * 数据库名称
     */
    @TableField
    private String databaseName;
    /**
     * 数据表名称
     */
    @TableField
    private String tableName;
    /**
     * 数据表中文名称
     */
    @TableField
    private String tableChineseName;
    /**
     * 字段名称
     */
    @TableField
    private String fieldName;
    /**
     * 字段中文名
     */
    @TableField
    private String fieldChineseName;
    /**
     * 表数据量
     */
    @TableField
    private String tableRows;
    /**
     * 数据元ID
     */
    @TableField
    private String deId;
    /**
     * 数据元标识符（DE）
     */
    @TableField
    private String deCode;
    /**
     * 内部标识
     */
    @TableField
    private String deInnercode;
    /**
     * 定义
     */
    @TableField
    private String deDefine;
    /**
     * 数据元值的数据类型
     */
    @TableField
    private String deType;
    /**
     * 表示格式
     */
    @TableField
    private String deFormat;
    /**
     * 数据元允许值
     */
    @TableField
    private String allowValue;
    /**
     * 数据元名称
     */
    @TableField
    private String deDesc;
    /**
     * 数据元英文名称
     */
    @TableField
    private String deEnName;
    /**
     * 数据集名称
     */
    @TableField
    private String datasetStrucDesc;
    /**
     * 数据集英文名称
     */
    @TableField
    private String datasetStrucEnname;
    /**
     * 数据生成日期
     */
    @TableField
    private Date createDate;
    /**
     * 更新日期
     */
    @TableField
    private Date modifiedDate;
    /**
     * 创建者
     */
    @TableField
    private String creator;
    /**
     * 修改者
     */
    @TableField
    private String modifier;
    /**
     * 备注
     */
    @TableField
    private String remarks;
    /**
     * 1 表示删除  0 表示未删除
     */
    @TableField
    private String delState;


}
