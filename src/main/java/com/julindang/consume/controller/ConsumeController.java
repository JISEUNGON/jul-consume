package com.julindang.consume.controller;

import com.julindang.consume.dto.response.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.julindang.consume.dto.request.ConsumeSaveRequestDto;
import com.julindang.consume.service.ConsumeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consume")
@RequiredArgsConstructor
@Slf4j
public class ConsumeController {
    private final ConsumeService consumeService;

    /**
     * 당 섭취 기록 추가
     * */
    @PostMapping("/save")
    public ResponseEntity<ConsumeSaveResponseDto> save(@RequestBody ConsumeSaveRequestDto dto) {
        return ResponseEntity.ok(consumeService.save(dto));
    }

    /**
     * 오늘의 총 당 섭취량
     * */
    @GetMapping("/total")
    public ResponseEntity<TodayTotalConsumeResponseDto> getTodayTotalConsume() {
        return ResponseEntity.ok(consumeService.getTodayTotalConsume());
    }

    /**
     * 오늘의 당 섭취 기록
     * */
    @GetMapping("/today")
    public ResponseEntity<TodayConsumeResponseDto> getTodayConsumes() {
        return ResponseEntity.ok(consumeService.getTodayConsumes());
    }

    /**
     * 일별 섭취량
     * */
    @GetMapping("/day")
    public ResponseEntity<List<ConsumeOfDayResponseDto>> getConsumeOfDay() {
        return ResponseEntity.ok(consumeService.getConsumeOfDay());
    }

    /**
     * 주별 섭취량
     * */
    @GetMapping("/week")
    public ResponseEntity<List<ConsumeOfWeekResponseDto>> getConsumeOfWeek() {
        return ResponseEntity.ok(consumeService.getConsumeOfWeek());
    }

    /**
     * 월별 섭취량
     * */
}
