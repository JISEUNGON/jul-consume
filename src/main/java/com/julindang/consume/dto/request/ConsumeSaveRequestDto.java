package com.julindang.consume.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ConsumeSaveRequestDto {
    private String name;
    private Double sugar;
    private Double calorie;
}
