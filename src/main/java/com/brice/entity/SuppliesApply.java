package com.brice.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SuppliesApply {
    private Long id;
    private Long residentId;
    private Long suppliesId;
    private Integer number;
    private LocalDateTime applyTime;
    private Integer status;
    private String reply;
}
