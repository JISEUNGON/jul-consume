package com.julindang.consume.dto.response;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ConsumeOfDayResponseDto {
    private LocalDate date;
    private Long sugar;
}
