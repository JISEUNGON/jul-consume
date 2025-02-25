package com.julindang.consume.dto.request;

import com.julindang.consume.vo.PersonalOption;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ConsumeSaveRequestDto {
    private String cafeName;
    private String beverageName;
    private Boolean hot;
    private Long volume;
    private String size;
    private Long sugar;
    private Long calorie;
    private List<PersonalOption> toppings;
}
