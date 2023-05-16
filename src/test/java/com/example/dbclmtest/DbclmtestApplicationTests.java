package com.example.dbclmtest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = com.example.dbclmtest.infrastructure.config.spring.DbclmtestApplication.class)
class DbclmtestApplicationTests {

    @Test
    void contextLoads() {
        Assertions.assertTrue(true);
    }

}
