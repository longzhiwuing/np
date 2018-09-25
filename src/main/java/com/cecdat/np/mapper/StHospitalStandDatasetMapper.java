package com.cecdat.np.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.cecdat.np.entity.StHospitalStandardDataset;
import com.cecdat.np.entity.StStandDrs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * st_hospital_dataset Mapper 接口
 * </p>
 *
 * @author chenzhongyong@cecdat.com
 * @since 2018-06-29
 */
@Mapper
public interface StHospitalStandDatasetMapper extends SuperMapper<StHospitalStandardDataset> {
    List<StHospitalStandardDataset> selectStandDataSet(Pagination page, @Param("searchText") String searchText);

    int selectCountStandDataSet(@Param("searchText") String searchText);

    List<StStandDrs> selectStandDataSetById(Pagination page, String id);

    List<StHospitalStandardDataset> selectStandDataSetInfoById(String id);

    int selectCountStandDataSetById(String id);

}
