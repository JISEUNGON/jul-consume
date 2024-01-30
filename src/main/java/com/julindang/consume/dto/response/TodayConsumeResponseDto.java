package com.julindang.consume.dto.response;

import lombok.*;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TodayConsumeResponseDto {
    private Long totalConsume;
}
