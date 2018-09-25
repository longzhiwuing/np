package com.cecdat.np.dto;

import lombok.Data;

/**
 * Create with IntelliJ IDEA.
 *
 * @author: hezhuangzhuang@cecdat.com
 * Date: 2018/6/25
 * Time: 18:42
 */
@Data
public class OutpatientAnalysisDTO {
    /**
     * 医院名称
     */
    private String hospitalName;
    /**
     * 门急诊人次
     */
    private Integer dispRegisterNumByTime;
    /**
     * 人均费用
     */
    private double avgFeeByPeople;
    /**
     * 药占比
     */
    private double medicineProportion;
    /**
     * 耗材材比
     */
    private double consumablesProportion;
    /**
     * 检查费占比
     */
    private double checkFeeProportion;
    /**
     * 化验费占比
     */
    private double laboratoryFeeProportion;
    /**
     * 门诊手术例数和
     */
    private Integer disp0perationNumSum;
    /**
     * 门急诊处方数和
     */
    private Integer prescribeDispNumSum;
    /**
     * 专家门诊和
     */
    private Integer dispProfessionNumSum;
    /**
     * 门诊收入和
     */
    private double incomeDispSum;
    /**
     * 门诊药品收入和
     */
    private double incomePhysicDispSum;
    /**
     * 门诊卫生材料收入和
     */
    private double incomeMaterialDispSum;
    /**
     * 门诊治疗收入和
     */
    private double incomeTreatDispSum;
    /**
     * 门诊检查收入和
     */
    private double incomeCheckDispSum;
    /**
     * 门诊化验收入和
     */
    private double incomeLaboratoryDispSum;
    /**
     * 门诊手术收入
     */
    private double incomeOperationDispSum;
    /**
     * 门诊其他收入
     */
    private double incomeOtherDispSum;
    /**
     * 门诊床位收入
     */
    private double incomeBedDispSum;


    /*
        医师平均担负门急诊人次
     */
    private Integer docAvgOeManTime;


    /*
        门诊费用
    */
    private Double incomeDisp;
    /*
        药品费用
     */
    private Double incomePhysicDisp;
    /*
        材料费用
     */
    private Double incomeMaterialDisp;
    /*
        治疗费用
     */
    private Double incomeTreatDisp;
    /*
        检查费用
     */
    private Double incomeCheckDisp;
    /*
        化验费
     */
    private Double incomeLaboratoryDisp;
    /*
        手术费
     */
    private Double incomeOperationDisp;
    /*
        其他费
     */
    private Double incomeOtherDisp;
    /*
        床位费用
     */
    private Double incomeBedDisp;
}
