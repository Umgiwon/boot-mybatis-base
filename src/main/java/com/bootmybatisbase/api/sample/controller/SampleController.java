package com.bootmybatisbase.api.sample.controller;

import com.bootmybatisbase.api.sample.service.SampleService;
import com.bootmybatisbase.api.sample.service.SampleServiceTx;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Operation(summary = "샘플 상세 조회", description = "샘플 순번으로 조회")
    @GetMapping("/{sampleSn}")
    public ResponseEntity<?> getSample(@PathVariable Long sampleSn) {
        return ResponseEntity.ok(sampleService.getSample(sampleSn));
    }
}
