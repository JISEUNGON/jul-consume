package com.julindang.consume.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "consume_topping")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ConsumeTopping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int")
    private Long id;

    @Column(name = "consume_id", columnDefinition = "int")
    private Long consumeId;

    @Column(name = "topping_id", columnDefinition = "bigint")
    private Long toppingId;

    @Column(name = "number", columnDefinition = "int")
    private Long number;
}
