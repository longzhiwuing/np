package com.cecdat.np.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * st_hospital_dataset
 * </p>
 *
 * @author chenzhongyong@cecdat.com
 * @since 2018-06-29
 */
@Data
@Accessors(chain = true)
public class StHospitalDataset implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
    private Integer sequenceNo;
    /**
     * 数据元ID
     */
    private String drsItemId;
    /**
     * 数据集名称
     */
    private String datasetName;
    /**
     * 业务系统
     */
    private String businessSystem;
    /**
     * 应用主题
     */
    private String applicationTheme;
    /**
     * 数据元总数
     */
    private String drsRows;
    /**
     * 关联数据总数
     */
    private String dataTotal;
    /**
     * 所属机构
     */
    private String medicalOrgName;


}
