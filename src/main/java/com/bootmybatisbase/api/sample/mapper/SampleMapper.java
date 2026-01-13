package com.bootmybatisbase.api.sample.mapper;

import com.bootmybatisbase.api.sample.vo.SampleVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//@Mapper
public interface SampleMapper {

    /**
     * 샘플 목록 조회
     * @param offset 시작점
     * @param limit 끝점
     * @return 샘플 목록
     */
    List<SampleVO> getSampleList(
            @Param("offset") int offset,
            @Param("limit") int limit
    );

    /**
     * 샘플 전체목록 카운트
     */
    long countSampleList();

    /**
     * 샘플 상세 조회
     * @param sampleSn 샘플 순번
     * @return 샘플
     */
    SampleVO getSample(@Param("sampleSn") Long sampleSn);
}
