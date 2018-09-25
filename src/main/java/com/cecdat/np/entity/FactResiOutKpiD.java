package com.cecdat.np.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 出院病人指标日表
 * </p>
 *
 * @author chenzhongyong@cecdat.com
 * @since 2018-06-25
 */
@Data
@TableName("fact_resi_out_kpi_d")
public class FactResiOutKpiD implements Serializable {

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
     * 住院号
     */
   @TableField
    private String residenceNo;
    /**
     * 病人ID
     */
   @TableField
    private String sickId;
    /**
     * 住院序号
     */
   @TableField
    private String visitNumber;
    /**
     * 日期  到日期，不能带时、分、
     */
   @TableField
    private Date dimDate;
    /**
     * 出院科室  科室维度字段，统一用dept_code,
     */
   @TableField
    private String deptCode;
    /**
     * 出院人次
     */
   @TableField
    private String outNum;
    /**
     * 自动出院人数
     */
   @TableField
    private String outAutoRens;
    /**
     * 出院病人住院天数
     */
   @TableField
    private String outStayDays;
    /**
     * 出院床日数
     */
   @TableField
    private String outBedNum;
    /**
     * 住院费用
     */
   @TableField
    private String outStayFee;
    /**
     * 药品费用
     */
   @TableField
    private String outPhysicFee;
    /**
     * 治疗费用
     */
   @TableField
    private String outClinicFee;
    /**
     * 检查费用
     */
   @TableField
    private String outCheckFee;
    /**
     * 手术费用
     */
   @TableField
    private String outOperationFee;
    /**
     * 床位费用
     */
   @TableField
    private String outBedFee;
    /**
     * 材料费用
     */
   @TableField
    private String outMaterialFee;
    /**
     * 化验费
     */
   @TableField
    private String outAssayFee;
    /**
     * 其他费
     */
   @TableField
    private String outOtherFee;
    /**
     * 住院重返数
     */
   @TableField
    private String returnRens;
    /**
     * 当天重返
     */
   @TableField
    private String returnTodayRens;
    /**
     * 第二天重返
     */
   @TableField
    private String return2dayRens;
    /**
     * 15天重返
     */
   @TableField
    private String return15dayRens;
    /**
     * 31天重返
     */
   @TableField
    private String return31dayRens;
    /**
     * 死亡人数
     */
   @TableField
    private String deathRens;
    /**
     * 出院治愈数
     */
   @TableField
    private String outCureNum;
    /**
     * 出院好转数
     */
   @TableField
    private String outMendNum;
    /**
     * 出院未愈数
     */
   @TableField
    private String outNotCureNum;
    /**
     * 出院其它数
     */
   @TableField
    private String outOtherNum;
    /**
     * 出院医保病人数
     */
   @TableField
    private String outInsuranceRens;
    /**
     * 出院外地病人数
     */
   @TableField
    private String outWaidiRens;
    /**
     * 出院外籍病人数
     */
   @TableField
    private String outForeignRens;
    /**
     * 感染数
     */
   @TableField
    private String infectRens;
    /**
     * 恶性肿瘤人数
     */
   @TableField
    private String malignancyRens;
    /**
     * PCI数
     */
   @TableField
    private String pciRens;
    /**
     * 产妇数
     */
   @TableField
    private String motherRens;
    /**
     * 新生儿数
     */
   @TableField
    private String babyRens;
    /**
     * 活产儿数
     */
   @TableField
    private String birthsLiveRens;
    /**
     * 活产儿产伤数
     */
   @TableField
    private String birthInjuryRens;
    /**
     * 器械辅助分娩人数
     */
   @TableField
    private String assistedBirthRens;
    /**
     * 器械辅助分娩产伤人数
     */
   @TableField
    private String assistedBirthInjuryRens;
    /**
     * 非器械辅助分娩人数
     */
   @TableField
    private String nonAssistedBirthRens;
    /**
     * 非器械辅助分娩产伤人数
     */
   @TableField
    private String nonAssistedBirthInjuryRens;
    /**
     * 输血人数
     */
   @TableField
    private String bloodRens;
    /**
     * 输血反应人数
     */
   @TableField
    private String bloodReactionRens;
    /**
     * 输液人数
     */
   @TableField
    private String infusionRens;
    /**
     * 输液反应人数
     */
   @TableField
    private String infusionReactionRens;
    /**
     * 医源性气胸人数
     */
   @TableField
    private String latrogenicPneumothoraxRens;
    /**
     * 医源性气胸分母
     */
   @TableField
    private String latrogenicPneumothoraxFm;
    /**
     * 医源性意外穿刺或撕裂伤数
     */
   @TableField
    private String latrogenicLacerationsRens;
    /**
     * 医源性意外穿刺或撕裂分母
     */
   @TableField
    private String latrogenicLacerationsFm;
    /**
     * 用药错误人数  取不了数，无取数口径
     */
   @TableField
    private String medicalErrorRens;
    /**
     * 手术发生异物遗留人数
     */
   @TableField
    private String operatForeignLeftRen;
    /**
     * 手术发生异物遗留分母
     */
   @TableField
    private String operatForeignLeftFm;
    /**
     * 门诊与出院诊断是否符
     */
   @TableField
    private String conformClinicOut;
    /**
     * 入院与出院诊断是否符合
     */
   @TableField
    private String conformInOut;
    /**
     * 手术冰冻与石蜡诊断符合数
     */
   @TableField
    private String conformSsbdysrNum;
    /**
     * 术前诊断与术后病理诊断符合数
     */
   @TableField
    private String conformOperation;
    /**
     * 临床与病理诊断是否符合
     */
   @TableField
    private String conformClinicPathology;
    /**
     * 放射与病理诊断是否符合
     */
   @TableField
    private String conformRadioPathology;
    /**
     * 死亡1天前病危上报人数
     */
   @TableField
    private String dangerous1dayReportRens;
    /**
     * 死亡前3天病危上报人数
     */
   @TableField
    private String dangerous3dayReportRens;
    /**
     * 入院一周内死亡人数
     */
   @TableField
    private String death1weekRens;
    /**
     * 入院两周内死亡人数
     */
   @TableField
    private String death2weekRens;
    /**
     * 病危人数  病案
     */
   @TableField
    private String dangerousRens;
    /**
     * 急诊人数  病案
     */
   @TableField
    private String emergencyRens;
    /**
     * 病重人数  病案
     */
   @TableField
    private String criticallyRens;
    /**
     * 抢救人数
     */
   @TableField
    private String salvageRens;
    /**
     * 抢救人次
     */
   @TableField
    private String salvageNum;
    /**
     * 抢救成功次数
     */
   @TableField
    private String salvageSuccess;
    /**
     * ICU数 转入
     */
   @TableField
    private String icuNum;
    /**
     * ICU转出人数
     */
   @TableField
    private String icuOutNum;
    /**
     * 24小时ICU重返
     */
   @TableField
    private String returnIcu24hour;
    /**
     * 48小时ICU重返
     */
   @TableField
    private String returnIcu48hour;
    /**
     * 辅助呼吸日数  分母
     */
   @TableField
    private String respirationAssistedDays;
    /**
     * 辅助呼吸抬高床头>30度日数  开嘱托长嘱
     */
   @TableField
    private String respirationOver30Days;
    /**
     * 呼吸机肺炎发生数
     */
   @TableField
    private String respirationPneumoniaRens;
    /**
     * 中心静脉导管留置日数  床日数
     */
   @TableField
    private String catheterDetainingDays;
    /**
     * 血流感染人数 院感
     */
   @TableField
    private String infectionBloodstreamRens;
    /**
     * 留置导尿日数 床日数
     */
   @TableField
    private String catheterizationDays;
    /**
     * 尿系感染人数 院感
     */
   @TableField
    private String infectUrinaryRens;
    /**
     * APACHEⅡ大于等于15分数  
     */
   @TableField
    private String apache2More15Rens;
    /**
     * APACHEⅡ小余15分数
     */
   @TableField
    private String apache2Less15Rens;
    /**
     * 人工气道意外脱落数
     */
   @TableField
    private String airwayAccidentalLossNum;
    /**
     * 高风险人数
     */
   @TableField
    private String highRiskRens;
    /**
     * 压疮人数
     */
   @TableField
    private String pressureRens;
    /**
     * 压疮人次
     */
   @TableField
    private String pressureNum;
    /**
     * 入院前压疮人数
     */
   @TableField
    private String pressureAdmissionRens;
    /**
     * 跌倒人数
     */
   @TableField
    private String fallRens;
    /**
     * 跌倒人次
     */
   @TableField
    private String fallNum;
    /**
     * [新]入径人数
     */
   @TableField
    private String clinicalPathRens;
    /**
     * [新]路径完成人数
     */
   @TableField
    private String clinicalPathCompleteRens;
    /**
     * [新]路径变异人数
     */
   @TableField
    private String clinicalPathChangeRens;
    /**
     * [新]退径人数
     */
   @TableField
    private String clinicalPathQuitRens;
    /**
     * 手术人数
     */
   @TableField
    private String operationRens;
    /**
     * 手术数（手术人次）
     */
   @TableField
    private String operationNum;
    /**
     * 手术申请人数
     */
   @TableField
    private String operationApplyNum;
    /**
     * 择期手术人数
     */
   @TableField
    private String operationElectiveRens;
    /**
     * 择期手术人次
     */
   @TableField
    private String operationElectiveNum;
    /**
     * 术前住院天数
     */
   @TableField
    private String operationWaitDays;
    /**
     * 手术持续小时数
     */
   @TableField
    private String operationStayHours;
    /**
     * 手术失血量
     */
   @TableField
    private String operationBloodLoseNum;
    /**
     * 手术输血量
     */
   @TableField
    private String operationBloodTranNum;
    /**
     * 二次再手术人数
     */
   @TableField
    private String operationRedoRens;
    /**
     * 术后一周内死亡人数
     */
   @TableField
    private String operationDeathWeekRens;
    /**
     * 手术冰冻石蜡数
     */
   @TableField
    private String operationFrozenNum;
    /**
     * 手术冰冻与石蜡诊断符合数1
     */
   @TableField
    private String conformOperationFrozenNum;
    /**
     * [存在]Ⅰ类切口手术病人
     */
   @TableField
    private String cutLevel1Rens;
    /**
     * [存在]II类切口病人数
     */
   @TableField
    private String cutLevel2Rens;
    /**
     * [只有]Ⅰ类切口手术病人
     */
   @TableField
    private String cutLevel1OnlyRens;
    /**
     * [只有]II类切口病人数
     */
   @TableField
    private String cutLevel2OnlyRens;
    /**
     * [存在]Ⅰ类切口感染人数
     */
   @TableField
    private String cutLevel1InfectRens;
    /**
     * [存在]II类切口感染人数
     */
   @TableField
    private String cutLevel2InfectRens;
    /**
     * 术前备皮数
     */
   @TableField
    private String preoperativeSkinRens;
    /**
     * I/甲级愈合数
     */
   @TableField
    private String heal1classRens;
    /**
     * 植入物人数
     */
   @TableField
    private String implantRens;
    /**
     * [新]介入治疗手术人数
     */
   @TableField
    private String interveneTreatRens;
    /**
     * 使用抗菌药人数
     */
   @TableField
    private String antiRens;
    /**
     * 住院治疗目的抗菌药人数
     */
   @TableField
    private String antiCureRens;
    /**
     * 住院治疗目的抗菌药送检人数
     */
   @TableField
    private String antiCureSendRens;
    /**
     * 治疗目的限制抗菌药人数
     */
   @TableField
    private String antiCureResrictRens;
    /**
     * 治疗目的限制抗菌药送检人数
     */
   @TableField
    private String antiCureResrictSendRens;
    /**
     * 治疗目的特殊抗菌药人数
     */
   @TableField
    private String antiCureSpecialRens;
    /**
     * 治疗目的特殊抗菌药送检人数
     */
   @TableField
    private String antiCureSpecialSendRens;
    /**
     * 使用预防抗菌药人数
     */
   @TableField
    private String antiPreventRens;
    /**
     * [新]预防抗菌药使用小时
     */
   @TableField
    private String antiPreventStayHours;
    /**
     * 使用一二代头孢菌素数
     */
   @TableField
    private String antiPrevent12cephalos;
    /**
     * 抗菌药累计DDD数
     */
   @TableField
    private String antiDddNum;
    /**
     * 非限制级累计DDD数
     */
   @TableField
    private String antiDddNoresrictNum;
    /**
     * 非限制级抗菌药人数
     */
   @TableField
    private String antiNoresrictRens;
    /**
     * 限制级累计DDD数
     */
   @TableField
    private String antiDddResrictNum;
    /**
     * 限制级抗菌药人数
     */
   @TableField
    private String antiResrictRens;
    /**
     * 特殊级累计DDD数
     */
   @TableField
    private String antiDddSpecialNum;
    /**
     * 特殊级抗菌药人数
     */
   @TableField
    private String antiSpecialRens;
    /**
     * 术前1小时内使用预防抗
     */
   @TableField
    private String within1hourAntiRens;
    /**
     * 术前30分至2小时预防
     */
   @TableField
    private String within2hourAntiRens;
    /**
     * 术中使用抗生素
     */
   @TableField
    private String operationAntiRens;
    /**
     * 术后24小时内停用预防
     */
   @TableField
    private String stopAntiIn24Rens;
    /**
     * 术后48小时内停用预防
     */
   @TableField
    private String stopAntiIn48Rens;
    /**
     * 术后72小时内停用预防
     */
   @TableField
    private String stopAntiIn72Rens;
    /**
     * 术后72小时继续使用预
     */
   @TableField
    private String addAntiAfter72Rens;


}
