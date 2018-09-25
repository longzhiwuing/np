package com.cecdat.np.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by roy on 2018/6/30.
 */
@Data
@TableName("dim_dept_dict")
public class DataResourceBaseInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private String serialNumber;
    @TableId
    private String dataName;
    @TableId
    private String medicalInstitutionsNum;
    @TableId
    private String dataCount;
    @TableId
    private String hospitalSystemName;


}
