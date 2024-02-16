package com.julindang.consume.service.consume;

import com.julindang.consume.domain.ConsumeTopping;
import com.julindang.consume.dto.response.*;
import com.julindang.consume.repository.ConsumeToppingRepository;
import com.julindang.consume.util.JwtUtil;
import com.julindang.consume.vo.PersonalOption;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.julindang.consume.domain.Consume;
import com.julindang.consume.dto.request.ConsumeSaveRequestDto;
import com.julindang.consume.repository.ConsumeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.julindang.consume.config.MapperConfig.modelMapper;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConsumeServiceImpl implements ConsumeService {
    private final ConsumeToppingRepository consumeToppingRepository;
    private final ConsumeRepository consumeRepository;

    @Override
    @Transactional
    public ConsumeSaveResponseDto save(ConsumeSaveRequestDto dto) {
        final Consume consume = consumeRepository.save(
                Consume.builder()
                        .cafeName(dto.getCafeName())
                        .beverageName(dto.getBeverageName())
                        .hot(dto.getHot())
                        .volume(dto.getVolume())
                        .size(dto.getSize())
                        .sugar(dto.getSugar())
                        .calorie(dto.getCalorie())
                        .memberEmail(JwtUtil.getEmail())
                        .memberId(JwtUtil.getMemberId())
                        .deleted(false)
                        .build()
        );

        for(PersonalOption topping: dto.getToppings()) {
            consumeToppingRepository.save(
                    ConsumeTopping.builder()
                            .consumeId(consume.getConsumeId())
                            .toppingName(topping.getToppingName())
                            .number(topping.getNumber())
                            .build()
            );
        }

        ConsumeSaveResponseDto map = modelMapper.map(consume, ConsumeSaveResponseDto.class);

        map.setName(consume.getBeverageName());

        return map;
    }

    @Override
    @Transactional
    public List<ConsumeAllResponseDto> getAll() {
        List<Consume> byMemberId = consumeRepository.findByMemberIdAndDeletedIsFalse(JwtUtil.getMemberId());
        List<ConsumeAllResponseDto> responseDtoList = new ArrayList<>();

        for (Consume consume: byMemberId) {
            ConsumeAllResponseDto map = modelMapper.map(consume, ConsumeAllResponseDto.class);

            map.setOptions(consumeToppingRepository.findByConsumeId(map.getConsumeId()));

            responseDtoList.add(map);
        }

        return responseDtoList;
    }
}
