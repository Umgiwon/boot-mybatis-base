package com.bootmybatisbase.api.sample.service;

import com.bootmybatisbase.api.sample.mapper.SampleMapper;
import com.bootmybatisbase.api.sample.vo.SampleVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SampleService {

    private final SampleMapper sampleDao;

    /**
     * 샘플 단건 조회
     * @param sampleSn 샘플 순번
     * @return 샘플
     */
    public SampleVO getSample(Long sampleSn) {
        return sampleDao.getSample(sampleSn);
    }
}
