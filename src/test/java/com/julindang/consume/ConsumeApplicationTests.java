package com.julindang.consume;

import com.julindang.consume.dto.response.TodayTotalConsumeResponseDto;
import com.julindang.consume.service.consume.ConsumeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConsumeApplicationTests {
    @Autowired
    private ConsumeService consumeService;

    @Test
    void contextLoads() {
        final TodayTotalConsumeResponseDto todayConsume = consumeService.getTodayTotalConsume();
    }

}
