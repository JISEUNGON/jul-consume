package com.julindang.consume.service;

import com.julindang.consume.dto.request.ConsumeSaveRequestDto;
import com.julindang.consume.dto.response.ConsumeSaveResponseDto;
import com.julindang.consume.dto.response.TodayConsumeResponseDto;

public interface ConsumeService {
    public ConsumeSaveResponseDto save(ConsumeSaveRequestDto dto);
    public TodayConsumeResponseDto getTodayConsume();
}
