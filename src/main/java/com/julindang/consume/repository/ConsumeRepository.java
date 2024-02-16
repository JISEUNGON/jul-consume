package com.julindang.consume.repository;

import com.julindang.consume.domain.Consume;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ConsumeRepository extends JpaRepository<Consume, Long> {
    public List<Consume> findByMemberIdAndDeletedIsFalse(Long memberId);
}
