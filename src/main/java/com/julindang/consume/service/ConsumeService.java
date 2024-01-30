package com.julindang.consume.service;

import com.julindang.consume.dto.request.ConsumeSaveRequestDto;
import com.julindang.consume.dto.response.ConsumeSaveResponseDto;
import com.julindang.consume.dto.response.TodayConsumeResponseDto;
import com.julindang.consume.dto.response.TodayTotalConsumeResponseDto;

public interface ConsumeService {
    public ConsumeSaveResponseDto save(ConsumeSaveRequestDto dto);
    public TodayTotalConsumeResponseDto getTodayTotalConsume();
    public TodayConsumeResponseDto getTodayConsumes();
}
