package com.brice.entity;

import lombok.Data;

/**
 * 物资实体类
 *
 * @author Brice
 * @date 2023/05/20
 */
@Data
public class Supplies {
    /**
     * id
     */
    private Long id;
    /**
     * 类型id
     */
    private Long categoryId;
    /**
     * 物资名称
     */
    private String name;
    /**
     * 物资数量
     */
    private Integer total;
}
