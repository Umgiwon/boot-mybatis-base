package com.bootmybatisbase.api.sample.mapper;

import com.bootmybatisbase.api.sample.vo.SampleVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SampleMapper {

    SampleVO getSample(@Param("sampleSn") Long sampleSn);
}
