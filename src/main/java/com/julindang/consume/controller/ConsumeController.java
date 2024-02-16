package com.julindang.consume.controller;

import com.julindang.consume.domain.Consume;
import com.julindang.consume.dto.request.ConsumeFreeSaveRequestDto;
import com.julindang.consume.dto.response.*;
import com.julindang.consume.service.free.FreeConsumeService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.julindang.consume.dto.request.ConsumeSaveRequestDto;
import com.julindang.consume.service.consume.ConsumeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/consume")
@RequiredArgsConstructor
@Slf4j
public class ConsumeController {
    private final ConsumeService consumeService;
    private final FreeConsumeService freeConsumeService;

    /**
     * 당 섭취 기록 추가
     * */
    /*@Operation(description = "섭취 기록 추가 API")
    @PostMapping("/save")
    public ResponseEntity<ConsumeSaveResponseDto> save(@RequestBody ConsumeSaveRequestDto dto) {
        return ResponseEntity.ok(consumeService.save(dto));
    }*/
    @Operation(description = "섭취 기록 추가 API")
    @PostMapping("/save")
    public ResponseEntity<ConsumeSaveResponseDto> save(@RequestBody ConsumeSaveRequestDto dto) {
        return ResponseEntity.ok(consumeService.save(dto));
    }

    @Operation(description = "자율 기입")
    @PostMapping("/free-save")
    public ResponseEntity<ConsumeSaveResponseDto> save(@RequestBody ConsumeFreeSaveRequestDto dto) {
        return ResponseEntity.ok(freeConsumeService.save(dto));
    }

    /**
     * 오늘의 총 당 섭취량
     * */
    @Operation(description = "오늘의 총 당 섭취량 확인 API")
    @GetMapping("/total")
    public ResponseEntity<TodayTotalConsumeResponseDto> getTodayTotalConsume() {
        return ResponseEntity.ok(consumeService.getTodayTotalConsume());
    }

    /**
     * 오늘의 당 섭취 기록
     * */
    @Operation(description = "오늘의 총 당 섭취량 확인 API")
    @GetMapping("/today")
    public ResponseEntity<TodayConsumeResponseDto> getTodayConsumes() {
        return ResponseEntity.ok(consumeService.getTodayConsumes());
    }

    /**
     * 일별 섭취량
     * */
    @Operation(description = "일별 섭취량 확인 API")
    @GetMapping("/day")
    public ResponseEntity<List<ConsumeOfDayResponseDto>> getConsumeOfDay() {
        return ResponseEntity.ok(consumeService.getConsumeOfDay());
    }

    /**
     * 주별 섭취량
     * */
    @Operation(description = "주별 섭취량 확인 API")
    @GetMapping("/week")
    public ResponseEntity<List<ConsumeOfWeekResponseDto>> getConsumeOfWeek() {
        return ResponseEntity.ok(consumeService.getConsumeOfWeek());
    }

    /**
     * 월별 섭취량
     * */
}
