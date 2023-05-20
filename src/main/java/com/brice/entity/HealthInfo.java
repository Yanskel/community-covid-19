package com.brice.entity;

import java.time.LocalDateTime;

import lombok.Data;

/**
 * 健康信息实体类
 *
 * @author Brice
 * @date 2023/05/20
 */
@Data
public class HealthInfo {
    /**
     * id
     */
    private Long id;
    /**
     * 身份证
     */
    private Long residentId;
    /**
     * 居民名称
     */
    private String residentName;
    /**
     * 体温情况
     */
    private int temperature;
    /**
     * 新冠症状
     */
    private int symptom;
    /**
     * 健康码颜色
     */
    private int healthColor;
    /**
     * 行程卡状态
     */
    private int route;
    /**
     * 提交时间
     */
    private LocalDateTime submitTime;
}
