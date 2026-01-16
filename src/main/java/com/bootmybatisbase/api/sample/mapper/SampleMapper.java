package com.bootmybatisbase.api.sample.mapper;

import com.bootmybatisbase.api.sample.dto.request.SampleInsertReqDto;
import com.bootmybatisbase.api.sample.vo.SampleVO;
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
     * @param vo 저장할 vo
     * @return 저장 완료된 vo
     */
    SampleVO insertSample(SampleVO vo);

    /**
     * Sample 목록 조회
     * @param offset 시작점
     * @param limit 끝점
     * @return 조회된 vo 목록
     */
    List<SampleVO> getSampleList(
            @Param("offset") int offset,
            @Param("limit") int limit
    );

    /**
     * Sample 전체목록 카운트
     */
    long countSampleList();

    /**
     * Sample 상세 조회
     * @param sampleSn 샘플 순번
     * @return 샘플
     */
    SampleVO getSample(@Param("sampleSn") Long sampleSn);
}
