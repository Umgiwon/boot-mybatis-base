package com.bootmybatisbase.global.domain.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BaseDto {
    private String createdUser; // 등록자
    private LocalDateTime createdDate; // 등록일
    private String updatedUser; // 수정자
    private LocalDateTime updatedDate; // 수정일

    /**
     * 데이터 저장 기본정보 set
     * - 생성자, 생성일시, 수정자, 수정일시
     * @param user 생성자
     */
    public void insertInfoSet(String user) {
        this.createdUser = user;
        this.createdDate = LocalDateTime.now();
        this.updatedUser = user;
        this.updatedDate = LocalDateTime.now();
    }

    /**
     * 데이터 수정 기본정보 set
     * - 수정자, 수정일시
     * @param user 수정자
     */
    public void updateInfoSet(String user) {
        this.updatedUser = user;
        this.updatedDate = LocalDateTime.now();
    }
}
