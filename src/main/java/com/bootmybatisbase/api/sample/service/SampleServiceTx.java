package com.bootmybatisbase.api.sample.service;

import com.bootmybatisbase.api.sample.dto.request.SampleInsertReqDto;
import com.bootmybatisbase.api.sample.dto.response.SampleResDto;
import com.bootmybatisbase.api.sample.mapper.SampleMapper;
import com.bootmybatisbase.api.sample.vo.SampleVO;
import com.bootmybatisbase.global.exception.DataConflictException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class SampleServiceTx {

    private final SampleMapper sampleDao;

    /**
     * Sample 저장
     * @param reqDto 요청 dto
     * @return 저장 완료된 Sample dto
     */
    public SampleResDto insertSample(SampleInsertReqDto reqDto) {

        // 저장 전 data validate
        validateSample(reqDto);

        // dto -> vo 변환
        SampleVO vo = SampleVO.builder()
                .title(reqDto.getTitle())
                .content(reqDto.getContent())
                // TODO 로그인 정보 세팅 필요
                .createdUser("TEST")
                .updatedUser("TEST")
                .build();

        // 저장 및 결과 반환
        SampleVO result = sampleDao.insertSample(vo);

        return SampleResDto.from(result);
    }

    /**
     * Sample 저장 전 validate
     * @param reqDto 요청 dto
     */
    private void validateSample(SampleInsertReqDto reqDto) {

        // 중복 여부 조회
        SampleInsertReqDto.DuplicateCheckResult result = sampleDao.existsSample(reqDto);

        // 제목 중복 체크
        if (Boolean.TRUE.equals(result.getTitleExists())) {
            throw new DataConflictException(reqDto.getTitle());
        }

        // 내용 중복체크
        if (Boolean.TRUE.equals(result.getContentExists())) {
            throw new DataConflictException(reqDto.getContent());
        }
    }


}
