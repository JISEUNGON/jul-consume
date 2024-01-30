package com.julindang.consume.vo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ConsumeVo {
    private Long consumeId;
    private String name;
    private Long sugar;
    private Long calorie;
}
