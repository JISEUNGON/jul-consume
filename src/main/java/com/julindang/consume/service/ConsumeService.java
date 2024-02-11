package com.julindang.consume.service;

import com.julindang.consume.dto.request.ConsumeSaveRequestDto;
import com.julindang.consume.dto.response.*;

import java.util.List;

public interface ConsumeService {
    public ConsumeSaveResponseDto save(ConsumeSaveRequestDto dto);
    public TodayTotalConsumeResponseDto getTodayTotalConsume();
    public TodayConsumeResponseDto getTodayConsumes();
    public List<ConsumeOfDayResponseDto> getConsumeOfDay();
    public List<ConsumeOfWeekResponseDto> getConsumeOfWeek();
}
