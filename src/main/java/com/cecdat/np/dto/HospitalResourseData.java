package com.cecdat.np.dto;

import lombok.Data;

/**
 * @Description: 医院资源分析,床位明细dto
 *
 * @author: liuzihao@cecdat.com
 * Date: 2018/6/25
 * Time: 20:06
 */
@Data
public class HospitalResourseData {

    /*
        医生数
     */
    private Integer doctorCount;
    /*
        医院名称
     */
    private String hospitalName;
    /*
        护士数
     */
    private Integer nurseCount;
    /*
        医生护士比
     */
    private Double docNurseRatio;
    /*
        医生床位比
     */
    private Double docBedRatio;
    /*
        门急诊人次
     */
    private Integer oeManTime;
    /*
        平均开放床位数
     */
    private Integer bedOpenNum;
    /*
        实际开放总床日数
     */
    private Integer bedOpenCount;
    /*
        医师平均担负门急诊人次
     */
    private Integer docAvgOeManTime;
    /*
        出院者占用床日数
     */
    private Integer outBedNum;

    /*
        医师平均担负住院床日数
     */
    private Integer docLoadBedCount;
}
