package com.bootmybatisbase.global.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseAudit {
    private String createdUser; // 등록자
    private LocalDateTime createdDate; // 등록일
    private String updatedUser; // 수정자
    private LocalDateTime updatedDate; // 수정일
}
