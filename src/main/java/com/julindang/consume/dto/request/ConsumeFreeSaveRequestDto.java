package com.julindang.consume.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ConsumeFreeSaveRequestDto {
    private String name;
    private Long sugar;
    private Long calorie;
}
