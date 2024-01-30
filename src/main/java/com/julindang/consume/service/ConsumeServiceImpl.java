package com.julindang.consume.service;

import com.julindang.consume.dto.response.TodayConsumeResponseDto;
import com.julindang.consume.exception.consume.ParameterNullOrEmptyException;
import com.julindang.consume.util.JwtUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.julindang.consume.domain.Consume;
import com.julindang.consume.dto.request.ConsumeSaveRequestDto;
import com.julindang.consume.dto.response.ConsumeSaveResponseDto;
import com.julindang.consume.repository.ConsumeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static com.julindang.consume.config.MapperConfig.modelMapper;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConsumeServiceImpl implements ConsumeService {
    private final ConsumeRepository consumeRepository;

    @Override
    @Transactional
    public ConsumeSaveResponseDto save(ConsumeSaveRequestDto dto) {
        if(dto.getName() == null)
            throw new ParameterNullOrEmptyException("Parameter Name is null.");

        if(dto.getName().isBlank() || dto.getName().isEmpty())
            throw new ParameterNullOrEmptyException("Parameter Name is Empty or blank.");

        if(dto.getSugar() <= 0D)
            throw new ParameterNullOrEmptyException("Parameter Sugar is less equal than zero");

        if(dto.getCalorie() <= 0D)
            throw new ParameterNullOrEmptyException("Parameter Calorie is less equal than zero");

        return modelMapper.map(
                consumeRepository.save(
                        Consume.builder()
                                .calorie(dto.getCalorie())
                                .sugar(dto.getSugar())
                                .name(dto.getName())
                                .memberId(JwtUtil.getMemberId())
                                .memberEmail(JwtUtil.getEmail())
                                .deleted(false)
                                .build()
                ),
                ConsumeSaveResponseDto.class
        );
    }

    @Override
    @Transactional
    public TodayConsumeResponseDto getTodayConsume() {
        final List<Consume> todayConsumes = consumeRepository.findByCreatedAt(LocalDate.now());
        Double consumes = 0D;

        for(Consume consume: todayConsumes) {
            consumes += consume.getSugar();
        }

        return TodayConsumeResponseDto.builder()
                .totalConsume(Math.round(consumes))
                .build();
    }
}
