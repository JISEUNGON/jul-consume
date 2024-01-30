package com.julindang.consume;

import com.julindang.consume.dto.response.TodayConsumeResponseDto;
import com.julindang.consume.service.ConsumeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConsumeApplicationTests {
    @Autowired
    private ConsumeService consumeService;

    @Test
    void contextLoads() {
        final TodayConsumeResponseDto todayConsume = consumeService.getTodayConsume();
    }

}
