package com.julindang.consume.repository;

import com.julindang.consume.domain.FreeConsume;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FreeConsumeRepository extends JpaRepository<FreeConsume, Long> {
    public List<FreeConsume> findByMemberIdAndDeletedIsFalse(Long memberId);
}
