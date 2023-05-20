package com.brice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

/**
 * 启动类
 *
 * @author Brice
 * @date 2023/05/20
 */
@Slf4j
@SpringBootApplication
public class CommunityCovid19Application {

    public static void main(String[] args) {
        SpringApplication.run(CommunityCovid19Application.class, args);
        log.info("===== 项目启动成功 =====");
    }

}
