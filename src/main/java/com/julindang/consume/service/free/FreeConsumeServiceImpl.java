package com.julindang.consume.service.free;

import com.julindang.consume.domain.FreeConsume;
import com.julindang.consume.dto.request.ConsumeFreeSaveRequestDto;
import com.julindang.consume.dto.response.ConsumeSaveResponseDto;
import com.julindang.consume.repository.FreeConsumeRepository;
import com.julindang.consume.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.julindang.consume.config.MapperConfig.modelMapper;

@Service
@RequiredArgsConstructor
@Slf4j
public class FreeConsumeServiceImpl implements FreeConsumeService {
    private final FreeConsumeRepository freeConsumeRepository;

    @Override
    @Transactional
    public ConsumeSaveResponseDto save(final ConsumeFreeSaveRequestDto dto) {
        return modelMapper.map(freeConsumeRepository.save(FreeConsume.builder()
                        .name(dto.getName())
                        .calorie(dto.getCalorie())
                        .sugar(dto.getSugar())
                        .memberEmail(JwtUtil.getEmail())
                        .memberId(JwtUtil.getMemberId())
                        .deleted(false)
                .build()), ConsumeSaveResponseDto.class);
    }
}
