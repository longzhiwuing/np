package com.cecdat.np.dto;

import lombok.Data;

/**
 * 住院情况返回实体类
 * @author: jcl
 * Date: 2018/06/25
 * Time: 21:13
 */
@Data
public class HospitalData {
    //医院名称
    private String hospitalName;
    //入院人次
    private double admissionNum;
    //出院人次
    private double outNum;
    //出院床日数
    private double outBedNum;
    //31天重返人数
    private double return31DayRens;
    //实际占用床位数
    private double bedUserNum;
    //实际开放床位数
    private double bedOpenNum;
    //手术人数
    private double operationRens;
    //死亡人数
    private double deathRens;
    //医院机构代码
    private String hospitalId;
    //医院等级
    private String hospitalLevel;
    //科室名称
    private String deptName;
    //科室编码
    private String deptCode;

    private double outStayDays;

    /*
        医师平均担负住院床日数。
     */
    private Integer docLoadBedCount;
    /**
     * 手术人次和。
     */
    private Integer operationNumberSum;

}
