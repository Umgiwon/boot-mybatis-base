package com.bootmybatisbase.global.constant;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

/**
 * 스웨거 예제 json 상수
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE) // 인스턴스화 방지를 위한 private 생성자
public class SwaggerExampleConst {

    /* ==================== Paging ==================== */
    public static final String PAGING_EXAMPLE = """
                {
                    "page": 0,
                    "size": 10,
                    "sort": ["createdDate,desc"]
                }
            """;

    /* ==================== Sample ==================== */
    public static final String SAMPLE_INSERT_EXAMPLE_1 = """
                {
                    "title": "title11",
                    "content": "content11"
                }
            """;

    public static final String SAMPLE_UPDATE_EXAMPLE_1 = """
                {
                    "title": "수정할 제목1",
                    "content": "수정할 내용1"
                }
            """;
}
