package com.brice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class CommunityCovid19ApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(LocalDate.now());
    }

}
