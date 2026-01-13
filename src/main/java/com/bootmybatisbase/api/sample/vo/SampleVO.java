package com.bootmybatisbase.api.sample.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class SampleVO {

    private Long sampleSn; // 샘플 순번
    private String title; // 샘플 제목
    private String content; // 샘플 내용
    private String createdUser; // 등록자
    private LocalDateTime createdDate; // 등록일
    private String updatedUser; // 수정자
    private LocalDateTime updatedDate; // 수정일
}
