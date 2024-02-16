package com.julindang.consume.repository;

import com.julindang.consume.domain.ConsumeTopping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsumeToppingRepository extends JpaRepository<ConsumeTopping, Long> {
    public List<ConsumeTopping> findByConsumeId(Long consumeId);
}
