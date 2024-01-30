package com.julindang.consume.dto.response;

import com.julindang.consume.vo.ConsumeVo;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class TodayConsumeResponseDto {
    private Long totalSugar;
    private Long totalCalorie;
    private List<ConsumeVo> consumeVoList;
}
