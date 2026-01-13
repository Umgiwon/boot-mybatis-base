package com.bootmybatisbase.global.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * 페이징 처리를 위한 클래스
 */
@Data
@AllArgsConstructor
public class PageResponse<T> {
    private List<T> contents;
    private Pagination pagination;
}
