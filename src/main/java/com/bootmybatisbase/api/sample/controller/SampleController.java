package com.bootmybatisbase.api.sample.controller;

import com.bootmybatisbase.api.sample.service.SampleService;
import com.bootmybatisbase.api.sample.service.SampleServiceTx;
import com.bootmybatisbase.api.sample.vo.SampleVO;
import com.bootmybatisbase.global.annotation.common.CustomApiLogger;
import com.bootmybatisbase.global.domain.dto.BaseResponse;
import com.bootmybatisbase.global.domain.dto.BaseResponseFactory;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Sample API", description = "샘플 API")
@CustomApiLogger
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/sample")
public class SampleController {

    private final SampleService sampleService;      // 조회 전용
    private final SampleServiceTx sampleServiceTx;  // 생성, 수정, 삭제 전용

    @Operation(summary = "샘플 목록 조회", description = "샘플 목록 페이징 처리")
    @GetMapping("")
    public BaseResponse<List<SampleVO>> getSampleList(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return BaseResponseFactory.success(sampleService.getSampleList(page, size));
    }

    @Operation(summary = "샘플 상세 조회", description = "샘플 순번으로 조회")
    @GetMapping("/{sampleSn}")
    public BaseResponse<SampleVO> getSample(@PathVariable Long sampleSn) {
        return BaseResponseFactory.success(sampleService.getSample(sampleSn));
    }
}
