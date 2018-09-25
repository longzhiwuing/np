package com.cecdat.np.dto;

import lombok.Data;

/**
 * 住院费用返回实体类
 * @author: jcl
 * Date: 2018/06/26
 * Time: 20:12
 */
@Data
public class HospitalCostData {
    //医院名称
    private String hospitalName;
    //住院收入
    private double incomeResi;
    //出院人次
    private double outNum;
    //住院药品收入
    private double incomePhysicResi;
    //住院耗材收入
    private double incomeMaterialResi;
    //住院检查收入
    private double incomeCheckResi;
    //住院化验收入
    private double incomeLaboratoryResi;
    /*
        住院费用。
    */
    private Double outStayFee;
    /*
        药品费用。
     */
    private Double outPhysicFee;
    /*
        材料费用。
     */
    private Double outMaterialFee;
    /*
        治疗费用。
     */
    private Double outClinicFee;
    /*
        检查费用。
     */
    private Double outCheckFee;
    /*
        化验费。
     */
    private Double outAssayFee;
    /*
        手术费。
     */
    private Double outOperationFee;
    /*
        其他费。
     */
    private Double outOtherFee;
    /*
        床位费用。
     */
    private Double outBedFee;

}
