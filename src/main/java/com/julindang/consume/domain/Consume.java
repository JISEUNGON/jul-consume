package com.julindang.consume.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "intake")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Consume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "consume_id", columnDefinition = "bigint")
    private Long consumeId;

    @Column(name = "name", columnDefinition = "varchar", length = 50)
    private String name;

    @Column(name = "sugar", columnDefinition = "double")
    private Double sugar;

    @Column(name = "calorie", columnDefinition = "double")
    private Double calorie;

    @Column(name = "member_id", columnDefinition = "bigint")
    private Long memberId;

    @Column(name = "member_email", columnDefinition = "varchar", length = 50)
    private String memberEmail;

    @Column(name = "created_at", columnDefinition = "datetime")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "deleted", columnDefinition = "tinyint")
    private Boolean deleted;
}
