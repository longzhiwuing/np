package com.cecdat.np.dto;

import lombok.Data;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/6/19
 * Time: 20:43
 */
@Data
public class BootStrapTableData<T> {
    private int total;
    private List<T> rows;
}
