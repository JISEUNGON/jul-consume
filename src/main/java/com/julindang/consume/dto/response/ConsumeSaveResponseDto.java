package com.julindang.consume.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ConsumeSaveResponseDto {
    private Long consumeId;
    private String name;
    private Double sugar;
    private Double calorie;
}
