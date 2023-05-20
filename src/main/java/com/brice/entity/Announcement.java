package com.brice.entity;

import java.time.LocalDateTime;

import lombok.Data;

/**
 * 公告实体类
 *
 * @author Brice
 * @date 2023/05/20
 */
@Data
public class Announcement {
    /**
     * id
     */
    private Long id;
    /**
     * 标题
     */
    private String title;
    /**
     * 公告内容
     */
    private String notice;
    /**
     * 公布时间
     */
    private LocalDateTime announceTime;
}
