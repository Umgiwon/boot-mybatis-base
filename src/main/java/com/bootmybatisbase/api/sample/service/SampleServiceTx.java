package com.bootmybatisbase.api.sample.service;

import com.bootmybatisbase.api.sample.dto.request.SampleSaveReqDto;
import com.bootmybatisbase.api.sample.dto.response.SampleResDto;
import com.bootmybatisbase.api.sample.mapper.SampleMapper;
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
    public SampleResDto insertSample(SampleSaveReqDto reqDto) {

        // 저장 전 data validate
        validateSample(reqDto);

        reqDto.insertInfoSet("SYSTEM"); // 저장정보 set (임시로 SYSTEM)

        return sampleDao.insertSample(reqDto);
    }

    /**
     * Sample 저장 전 validate
     * @param reqDto 요청 dto
     */
    private void validateSample(SampleSaveReqDto reqDto) {

        // 중복 여부 조회
        SampleSaveReqDto.DuplicateCheckResult result = sampleDao.existsSample(reqDto);

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
