package com.bootmybatisbase.api.sample.dto.response;

import com.bootmybatisbase.api.sample.vo.SampleVO;
import com.bootmybatisbase.global.domain.BaseAudit;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Schema(description = "샘플 응답 DTO")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SampleResDto extends BaseAudit implements Serializable {

    private Long sampleSn; // 샘플 순번
    private String title; // 샘플 제목
    private String content; // 샘플 내용

    /**
     * VO -> DTO 변환
     */
    public static SampleResDto from(SampleVO vo) {

        SampleResDto resDto = SampleResDto.builder()
                .sampleSn(vo.getSampleSn())
                .title(vo.getTitle())
                .content(vo.getContent())
                .build();

        resDto.setCreatedUser(vo.getCreatedUser());
        resDto.setCreatedDate(vo.getCreatedDate());
        resDto.setUpdatedUser(vo.getUpdatedUser());
        resDto.setUpdatedDate(vo.getUpdatedDate());

        return resDto;
    }
}
