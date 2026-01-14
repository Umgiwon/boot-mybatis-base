package com.bootmybatisbase.api.sample.dto.response;

import com.bootmybatisbase.global.domain.dto.BaseDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Schema(description = "샘플 응답 DTO")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SampleResDto extends BaseDto implements Serializable {

    private Long sampleSn; // 샘플 순번
    private String title; // 샘플 제목
    private String content; // 샘플 내용
}
