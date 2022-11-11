package com.brice.entity;

import lombok.Data;

@Data
public class Supplies {
    private Long id;
    private Long categoryId;
    private String name;
    private Integer total;
}
