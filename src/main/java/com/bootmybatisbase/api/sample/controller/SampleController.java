package com.bootmybatisbase.api.sample.controller;

import com.bootmybatisbase.api.sample.service.SampleService;
import com.bootmybatisbase.api.sample.service.SampleServiceTx;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Sample API", description = "샘플 API")
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/sample")
public class SampleController {

    private final SampleService sampleService;      // 조회 전용
    private final SampleServiceTx sampleServiceTx;  // 생성, 수정, 삭제 전용



}
