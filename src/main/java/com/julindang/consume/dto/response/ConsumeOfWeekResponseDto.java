package com.julindang.consume.dto.response;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ConsumeOfWeekResponseDto {
    private Long sugar;
    private Long week;
}
