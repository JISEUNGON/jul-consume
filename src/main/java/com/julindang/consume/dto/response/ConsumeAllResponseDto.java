package com.julindang.consume.dto.response;

import com.julindang.consume.domain.ConsumeTopping;
import com.julindang.consume.vo.PersonalOption;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ConsumeAllResponseDto {
    private Long consumeId;
    private String cafeName;
    private String beverageName;
    private Boolean hot;
    private Long volume;
    private String size;
    private Long sugar;
    private Long calorie;
    private List<ConsumeTopping> options;
    private LocalDateTime createdAt;
}
