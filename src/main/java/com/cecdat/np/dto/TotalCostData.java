package com.cecdat.np.dto;

import lombok.Data;

/**
 * 全院费用返回实体类
 * @author: jcl
 * Date: 2018/06/28
 * Time: 10:18
 */
@Data
public class TotalCostData {
    //医院名称
    private String hospitalName;
    //总收入
    private double incomeTotal;
    //药品总收入
    private double incomePhysic;
    //耗材总收入
    private double incomeMaterial;
    //检查总收入
    private double incomeCheck;
    //化验总收入
    private double incomeLaboratory;
    //治疗总收入
    private double incomeTreat;
    //手术总收入
    private double incomeOperation;
    //其他总收入
    private double incomeOther;
    //床位总收入
    private double incomeBed;
    /*
        医疗机构代码。
     */
    private String orgCode;
    /*
        门诊收入。
     */
    private Double incomeDisp;
    /*
        门急诊人次。
     */
    private Integer dispRegisterNum;
    /*
        住院收入。
     */
    private Double incomeResi;
    /*
        结算人次。
     */
    private Integer settleNum;

    /*
        全院费用分析结果计数。
     */
    private Integer totalCostCount;
}
