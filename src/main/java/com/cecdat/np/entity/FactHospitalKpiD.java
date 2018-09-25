package com.cecdat.np.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 医院指标汇总日表
 * </p>
 *
 * @author chenzhongyong@cecdat.com
 * @since 2018-06-25
 */
@Data
@TableName("fact_hospital_kpi_d")
public class FactHospitalKpiD implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 序列号
     */
    @TableId
    private String sequenceNo;
    /**
     * 数据生成日期
     */
    @TableField
    private Date createDate;
    /**
     * 医疗机构代码
     */
    @TableField
    private String orgCode;
    /**
     * 日期 到日期，不能带时、分、
     */
    @TableField
    private Date dimDate;
    /**
     * 科室 统一用dept_code,
     */
    @TableField
    private String deptCode;
    /**
     * 编制床位数
     */
    @TableField
    private String bedTheoryNum;
    /**
     * 实际开放床位数
     */
    @TableField
    private String bedOpenNum;
    /**
     * 实际占用床位数
     */
    @TableField
    private String bedUserNum;
    /**
     * 空床数
     */
    @TableField
    private String bedEmptyNum;
    /**
     * 职工数
     */
    @TableField
    private String staffRens;
    /**
     * 在编人数
     */
    @TableField
    private String staffPayrollRens;
    /**
     * 卫生技术人数
     */
    @TableField
    private String staffTechnologyRens;
    /**
     * 医生人数
     */
    @TableField
    private String staffDoctorRens;
    /**
     * 护理人数
     */
    @TableField
    private String staffNurseRens;
    /**
     * 医技人数
     */
    @TableField
    private String staffCureRens;
    /**
     * 药剂人数
     */
    @TableField
    private String staffDrugRens;
    /**
     * 其他卫生技术人数
     */
    @TableField
    private String staffTechnologyOtherRens;
    /**
     * 非卫生技术人数
     */
    @TableField
    private String staffNotechnologyRens;
    /**
     * 总收入
     */
    @TableField
    private String incomeTotal;
    /**
     * 门诊收入
     */
    @TableField
    private String incomeDisp;
    /**
     * 住院收入
     */
    @TableField
    private String incomeResi;
    /**
     * 药品收入 门诊药品+住院药品
     */
    @TableField
    private String incomePhysic;
    /**
     * 西药收入 门诊西药+住院西药
     */
    @TableField
    private String incomePhysicWest;
    /**
     * 抗菌药收入 门诊抗菌+住院抗菌
     */
    @TableField
    private String incomeAnti;
    /**
     * 卫生材料收入 门诊耗材+住院耗材
     */
    @TableField
    private String incomeMaterial;
    /**
     * 治疗收入 门诊治疗+住院治疗
     */
    @TableField
    private String incomeTreat;
    /**
     * 检查收入 门诊检查+住院检查
     */
    @TableField
    private String incomeCheck;
    /**
     * 化验收入 门诊化验+住院化验
     */
    @TableField
    private String incomeLaboratory;
    /**
     * 手术收入 门诊手术+住院手术
     */
    @TableField
    private String incomeOperation;
    /**
     * 体检收入
     */
    @TableField
    private String incomeMedicalNum;
    /**
     * 门诊药品收入
     */
    @TableField
    private String incomePhysicDisp;
    /**
     * 住院药品收入
     */
    @TableField
    private String incomePhysicResi;
    /**
     * 门诊西药收入
     */
    @TableField
    private String incomePhysicWestDisp;
    /**
     * 住院西药收入
     */
    @TableField
    private String incomePhysicWestResi;
    /**
     * 门诊抗菌药收入
     */
    @TableField
    private String incomeAntiDisp;
    /**
     * 住院抗菌药收入
     */
    @TableField
    private String incomeAntiResi;
    /**
     * 门诊卫生材料收入
     */
    @TableField
    private String incomeMaterialDisp;
    /**
     * 住院卫生材料收入
     */
    @TableField
    private String incomeMaterialResi;
    /**
     * 门诊治疗收入
     */
    @TableField
    private String incomeTreatDisp;
    /**
     * 住院治疗收入
     */
    @TableField
    private String incomeTreatResi;
    /**
     * 门诊检查收入
     */
    @TableField
    private String incomeCheckDisp;
    /**
     * 住院检查收入
     */
    @TableField
    private String incomeCheckResi;
    /**
     * 门诊化验收入
     */
    @TableField
    private String incomeLaboratoryDisp;
    /**
     * 住院化验收入
     */
    @TableField
    private String incomeLaboratoryResi;
    /**
     * 门诊手术收入
     */
    @TableField
    private String incomeOperationDisp;
    /**
     * 住院手术收入
     */
    @TableField
    private String incomeOperationResi;
    /**
     * 门急诊人次
     */
    @TableField
    private String dispRegisterNum;
    /**
     * 急诊人次
     */
    @TableField
    private String dispEmergencyNum;
    /**
     * 普通门诊
     */
    @TableField
    private String dispGeneralNum;
    /**
     * 专家门诊
     */
    @TableField
    private String dispProfessionNum;
    /**
     * 免费号
     */
    @TableField
    private String dispFreeNum;
    /**
     * 复诊人次
     */
    @TableField
    private String dispReplyNum;
    /**
     * 门诊医保人次
     */
    @TableField
    private String dispInsuranceNum;
    /**
     * 门诊外地病人数
     */
    @TableField
    private String dispWaidiNum;
    /**
     * 门诊外籍病人
     */
    @TableField
    private String dispForeignNum;
    /**
     * 留观人数
     */
    @TableField
    private String dispObservationNum;
    /**
     * 门诊手术例数
     */
    @TableField
    private String dispOperationNum;
    /**
     * 门诊体验人数
     */
    @TableField
    private String dispMedicalNum;
    /**
     * 门急诊处方数
     */
    @TableField
    private String prescribeDispNum;
    /**
     * 急诊处方数
     */
    @TableField
    private String prescribeEmergencyNum;
    /**
     * 中草药处方数
     */
    @TableField
    private String prescribeChineseNum;
    /**
     * 原有病人数
     */
    @TableField
    private String oldPatientNum;
    /**
     * 入院人次
     */
    @TableField
    private String admissionNum;
    /**
     * 转入数
     */
    @TableField
    private String translateInNum;
    /**
     * 转出数
     */
    @TableField
    private String translateOutNum;
    /**
     * 现有病人数
     */
    @TableField
    private String nowPatientNum;
    /**
     * 陪护数
     */
    @TableField
    private String accompanyNum;
    /**
     * 国内论文数ISSN
     */
    @TableField
    private String thesisInternalNum;
    /**
     * SCI收录论文数
     */
    @TableField
    private String thesisSciIncludeNum;
    /**
     * 国家科研课题数
     */
    @TableField
    private String topicCountryNum;
    /**
     * 省级科研课题数
     */
    @TableField
    private String topicProvincialNum;
    /**
     * 完成国家科研课题数
     */
    @TableField
    private String completeTopicCountryNum;
    /**
     * 完成省级科研课题数
     */
    @TableField
    private String completeTopicProvincialNum;
    /**
     * 获得国家科研基金额度
     */
    @TableField
    private String fundCountryNum;
    /**
     * 获得省级科研基金额度
     */
    @TableField
    private String fundProvincialNum;

}
