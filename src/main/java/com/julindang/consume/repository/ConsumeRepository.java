package com.julindang.consume.repository;

import com.julindang.consume.domain.Consume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ConsumeRepository extends JpaRepository<Consume, Long> {
    @Query("SELECT c FROM Consume c WHERE date(c.createdAt) = :now")
    public List<Consume> findByCreatedAt(@Param("now")LocalDate now);
}
