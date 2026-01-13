package com.bootmybatisbase.global.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Schema(description = "페이지네이션 정보")
@Data
@Builder
public class Pagination {

    @Schema(description = "현재 페이지 번호", example = "1")
    private int pageNumber;

    @Schema(description = "한 페이지당 보여질 데이터 개수", example = "10")
    private int pageSize;

    @Schema(description = "현재 페이지 데이터 개수", example = "3")
    private int numberOfElements;

    @Schema(description = "전체 데이터 개수", example = "17")
    private long totalElements;

    @Schema(description = "전체 페이지 개수", example = "3")
    private int totalPages;

    public static Pagination of(int pageNumber, int pageSize, int numberOfElements, long totalElements) {
        return Pagination.builder()
                .pageNumber(pageNumber)
                .pageSize(pageSize)
                .numberOfElements(numberOfElements)
                .totalElements(totalElements)
                .totalPages(
                        (int) Math.ceil((double) totalElements / pageSize) // 전체 개수 / 전체 페이지 개수
                )
                .build();
    }
}
