package com.julindang.consume.controller;

import com.julindang.consume.dto.response.ConsumeSaveResponseDto;
import com.julindang.consume.dto.response.TodayConsumeResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.julindang.consume.dto.request.ConsumeSaveRequestDto;
import com.julindang.consume.service.ConsumeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
     * 오늘의 섭취량
     * */
    @GetMapping("/today")
    public ResponseEntity<TodayConsumeResponseDto> getTodayConsume() {
        return ResponseEntity.ok(consumeService.getTodayConsume());
    }

    /**
     * 주별 섭취량
     * */

    /**
     * 월별 섭취량
     * */
}
