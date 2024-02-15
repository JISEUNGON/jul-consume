package com.julindang.consume.repository;

import com.julindang.consume.domain.Consume;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ConsumeRepository extends JpaRepository<Consume, Long> {
    @Query("SELECT c FROM Consume c WHERE date(c.createdAt) = :now and c.memberId = :memberId")
    public List<Consume> findByMemberIdAndCreatedAt(@Param("now")LocalDate now, @Param("memberId") Long memberId);

    @Query("SELECT c FROM Consume c WHERE (c.createdAt BETWEEN :start AND :end) and c.memberId = :memberId")
    public List<Consume> findByDayConsumes(@Param("start") LocalDate start, @Param("end") LocalDate end, Long memberId);

    @Query("SELECT c FROM Consume c WHERE (c.createdAt BETWEEN :start AND :end) and c.memberId = :memberId")
    List<Consume> findByWeekConsumes(LocalDate minusDays, LocalDate now, Long memberId);

    @Query("SELECT c FROM Consume c WHERE c.memberId = :memberId")
    List<Consume> findByMonth(Long memberId);
}
