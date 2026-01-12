package com.bootmybatisbase.api.sample.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class SampleVO {

    private Long sampleSn; // 샘플 순번
    private String title; // 샘플 제목
    private String content; // 샘플 내용
}
