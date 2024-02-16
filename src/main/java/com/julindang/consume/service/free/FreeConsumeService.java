package com.julindang.consume.service.free;

import com.julindang.consume.dto.request.ConsumeFreeSaveRequestDto;
import com.julindang.consume.dto.response.ConsumeSaveResponseDto;
import com.julindang.consume.dto.response.FreeConsumeAllResponseDto;

import java.util.List;

public interface FreeConsumeService {
    public ConsumeSaveResponseDto save(ConsumeFreeSaveRequestDto dto);
    public List<FreeConsumeAllResponseDto> getAll();
}
