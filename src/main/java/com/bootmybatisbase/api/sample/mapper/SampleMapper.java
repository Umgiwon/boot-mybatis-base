package com.bootmybatisbase.api.sample.mapper;

import com.bootmybatisbase.api.sample.dto.request.SampleInsertReqDto;
import com.bootmybatisbase.api.sample.dto.response.SampleResDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SampleMapper {

    /**
     * Sample 저장전 중복체크
     * @param reqDto 요청 dto
     * @return 중복 여부
     */
    SampleInsertReqDto.DuplicateCheckResult existsSample(SampleInsertReqDto reqDto);

    /**
     * Sample 저장
     * @param reqDto 요청 dto
     * @return 저장 완료된 Sample dto
     */
    SampleResDto insertSample(SampleInsertReqDto reqDto);

    /**
     * 샘플 목록 조회
     * @param offset 시작점
     * @param limit 끝점
     * @return 샘플 목록
     */
    List<SampleResDto> getSampleList(
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
    SampleResDto getSample(@Param("sampleSn") Long sampleSn);
}
