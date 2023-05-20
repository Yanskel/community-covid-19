package com.brice.entity;

import lombok.Data;

/**
 * 物资分类实体类
 *
 * @author Brice
 * @date 2023/05/20
 */
@Data
public class Category {
    /**
     * id
     */
    private Long id;
    /**
     * 类型
     */
    private String type;
}
