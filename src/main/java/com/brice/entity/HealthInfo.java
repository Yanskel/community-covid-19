package com.brice.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HealthInfo {
    private Long id;
    private Long residentId;
    private String residentName;  //居民名称
    private int temperature;    //体温情况
    private int symptom;    //新冠症状
    private int healthColor;    //健康码颜色
    private int route;  //行程卡状态
    private LocalDateTime submitTime;   //提交时间
}
