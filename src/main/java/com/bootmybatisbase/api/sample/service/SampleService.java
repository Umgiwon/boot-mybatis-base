package com.bootmybatisbase.api.sample.service;

import com.bootmybatisbase.api.sample.dto.response.SampleResDto;
import com.bootmybatisbase.api.sample.mapper.SampleMapper;
import com.bootmybatisbase.api.sample.vo.SampleVO;
import com.bootmybatisbase.global.domain.PageResponse;
import com.bootmybatisbase.global.domain.Pagination;
import com.bootmybatisbase.global.enums.common.ApiReturnCode;
import com.bootmybatisbase.global.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SampleService {

    private final SampleMapper sampleDao;

    /**
     * 샘플 목록 조회
     * @param page 페이지 번호
     * @param size 페이지 데이터 사이즈
     * @return 페이지 정보 + 샘플 목록
     */
    public PageResponse<SampleResDto> getSampleList(int page, int size) {

        // 페이징 조회정보 세팅
        int pageNumber = Math.max(page, 1);
        int offset = (pageNumber - 1) * size;

        // 목록 조회
        List<SampleVO> sampleVoList = sampleDao.getSampleList(offset, size);
        long totalCount = sampleDao.countSampleList();

        // vo -> dto 변환
        List<SampleResDto> sampleResDtoList = sampleVoList.stream().map(SampleResDto::from).toList();

        // 페이징 정보 세팅
        Pagination pagination = Pagination.of(pageNumber, size, sampleResDtoList.size(), totalCount);

        return new PageResponse<>(sampleResDtoList, pagination);
    }

    /**
     * 샘플 단건 조회
     * @param sampleSn 샘플 순번
     * @return 샘플
     */
    public SampleResDto getSample(Long sampleSn) {

        SampleVO result = sampleDao.getSample(sampleSn);

        if (ObjectUtils.isEmpty(result)) {
            throw new BusinessException(ApiReturnCode.NO_DATA_ERROR);
        }

        return SampleResDto.from(result);
    }
}
