package com.cecdat.np.mapper;

import com.cecdat.np.dto.SignBillData;
import com.cecdat.np.entity.SignBill;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SignBillMapper extends SuperMapper<SignBill> {

    List<SignBillData> selectSignBillList();
}
