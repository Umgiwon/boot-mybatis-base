package com.bootmybatisbase.api.sample.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Schema(description = "샘플 응답 DTO")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SampleResDto implements Serializable {

    private Long sampleSn; // 샘플 순번
    private String title; // 샘플 제목
    private String content; // 샘플 내용
}
