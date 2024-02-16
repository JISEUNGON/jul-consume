package com.julindang.consume.service.consume;

import com.julindang.consume.dto.response.*;
import com.julindang.consume.exception.consume.ParameterNullOrEmptyException;
import com.julindang.consume.util.JwtUtil;
import com.julindang.consume.vo.ConsumeVo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.julindang.consume.domain.Consume;
import com.julindang.consume.dto.request.ConsumeSaveRequestDto;
import com.julindang.consume.repository.ConsumeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

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
    public TodayTotalConsumeResponseDto getTodayTotalConsume() {
        final List<Consume> todayConsumes = consumeRepository.findByMemberIdAndCreatedAt(LocalDate.now(), JwtUtil.getMemberId());
        Double consumes = 0D;

        for(Consume consume: todayConsumes) {
            consumes += consume.getSugar();
        }

        return TodayTotalConsumeResponseDto.builder()
                .totalConsume(Math.round(consumes))
                .build();
    }

    @Override
    @Transactional
    public TodayConsumeResponseDto getTodayConsumes() {
        final List<Consume> todayConsumes = consumeRepository.findByMemberIdAndCreatedAt(LocalDate.now(), JwtUtil.getMemberId());
        List<ConsumeVo> consumeVoList = new ArrayList<>();
        Double calories = 0D;
        Double sugars = 0D;

        for(Consume consume: todayConsumes) {
            consumeVoList.add(modelMapper.map(consume, ConsumeVo.class));

            calories += consume.getCalorie();
            sugars += consume.getSugar();
        }

        return TodayConsumeResponseDto.builder()
                .totalCalorie(Math.round(calories))
                .totalSugar(Math.round(sugars))
                .consumeVoList(consumeVoList)
                .build();
    }

    @Override
    @Transactional
    public List<ConsumeOfDayResponseDto> getConsumeOfDay() {
        final List<Consume> byWeekConsumes = consumeRepository.findByDayConsumes(LocalDate.now().minusDays(6), LocalDate.now(), JwtUtil.getMemberId());
        List<ConsumeOfDayResponseDto> responseDtoList = new ArrayList<>();

        for (Consume consume: byWeekConsumes) {
            responseDtoList.add(
                    ConsumeOfDayResponseDto.builder()
                            .date(consume.getCreatedAt().toLocalDate())
                            .sugar(Math.round(consume.getSugar()))
                            .build()
            );
        }

        return responseDtoList;
    }

    @Override
    @Transactional
    public List<ConsumeOfWeekResponseDto> getConsumeOfWeek() {
        // 이번 달의 시작과 끝을 구합니다.
        LocalDate now = LocalDate.now();
        LocalDate start = now.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate end = now.with(TemporalAdjusters.lastDayOfMonth());

        // 이번 달의 데이터를 가져옵니다.
        List<Consume> consumes = consumeRepository.findByWeekConsumes(start, end, JwtUtil.getMemberId());

        // 주별로 그룹핑하고 sugar의 평균을 계산합니다.
        Map<Integer, Double> averages = consumes.stream()
                .collect(Collectors.groupingBy(
                        consume -> consume.getCreatedAt().toLocalDate().get(WeekFields.of(Locale.getDefault()).weekOfYear()),
                        Collectors.averagingDouble(Consume::getSugar)));

        log.info("averages: {}", averages);

        return null;
    }
}
