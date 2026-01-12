package com.bootmybatisbase.global.enums.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum TokenType {
    ACCESS,
    REFRESH,
}
