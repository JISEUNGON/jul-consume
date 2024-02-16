package com.julindang.consume.service.free;

import com.julindang.consume.dto.request.ConsumeFreeSaveRequestDto;
import com.julindang.consume.dto.response.ConsumeSaveResponseDto;

public interface FreeConsumeService {
    public ConsumeSaveResponseDto save(ConsumeFreeSaveRequestDto dto);
}
