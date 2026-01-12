package com.bootmybatisbase.api.sample.dao;

import com.bootmybatisbase.api.sample.vo.SampleVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SampleDao {

    SampleVO getSample(@Param("sampleSn") Long sampleSn);
}
