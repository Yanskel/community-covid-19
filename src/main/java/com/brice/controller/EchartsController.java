package com.brice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.hutool.http.HttpUtil;

/**
 * Echarts Controller
 *
 * @author Brice
 * @date 2023/05/20
 */
@RestController
@RequestMapping("/api/echarts")
public class EchartsController {

    @GetMapping("/epidemic")
    public String epidemic() {
        return HttpUtil.get("https://c.m.163.com/ug/api/wuhan/app/data/list-total?t=" + System.currentTimeMillis());
    }
}
