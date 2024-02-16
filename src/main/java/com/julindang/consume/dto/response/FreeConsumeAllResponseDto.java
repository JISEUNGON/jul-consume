package com.julindang.consume.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FreeConsumeAllResponseDto {
    private Long consumeId;
    private String name;
    private Long sugar;
    private Long calorie;
}
