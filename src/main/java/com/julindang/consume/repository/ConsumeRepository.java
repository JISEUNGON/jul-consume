package com.julindang.consume.repository;

import com.julindang.consume.domain.Consume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumeRepository extends JpaRepository<Consume, Long> {
}
