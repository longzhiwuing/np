package com.cecdat.np.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA
 *
 * @author: liuzihao@cecdat.com
 * Date: 2018/6/21
 * Time: 9:54
 */
@Data
@TableName("year_sign_bill_statistics")
public class SignBill implements Serializable{

    @TableId
    private int id;

    @TableField
    private int getCount;

    @TableField
    private int handleCount;

    @TableField
    private int dimYear;
}
