package com.bootmybatisbase.api.sample.dto.request;

import com.bootmybatisbase.global.domain.dto.BaseDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@EqualsAndHashCode(callSuper = true)
@Schema(description = "샘플 저장 조회 요청 DTO")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true) // json 데이터를 java 객체로 역직렬화 할 때 매핑되지 않은 필드를 무시
public class SampleSaveReqDto extends BaseDto {

    @NotBlank(message = "제목은 필수입니다")
    @Length(max = 30, message = "제목은 30글자 이하로 입력해야 합니다.")
    @Schema(description = "제목 입력값", example = "샘플의 저장할 제목")
    private String title;

    @NotBlank(message = "내용은 필수입니다")
    @Length(max = 150, message = "내용은 150글자 이하로 입력해야 합니다.")
    @Schema(description = "내용 입력값", example = "샘플의 저장할 내용")
    private String content;

    /**
     * 저장시 중복여부 응답 dto
     */
    @Getter
    public static class DuplicateCheckResult {
        private Boolean titleExists; // 제목 중복여부
        private Boolean contentExists; // 기타 중복여부 예시
    }
}
