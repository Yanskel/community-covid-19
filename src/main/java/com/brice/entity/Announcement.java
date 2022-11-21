package com.brice.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Announcement {
    private Long id;
    private String title;
    private String notice;
    private LocalDateTime announceTime;
}
