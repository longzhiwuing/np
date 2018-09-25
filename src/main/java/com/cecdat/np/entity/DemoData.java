package com.cecdat.np.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/6/19
 * Time: 18:02
 */
@Data
@TableName("demo_data")
public class DemoData implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String id;

    @TableField
    private String name;

    @TableField
    private Integer count;
}
