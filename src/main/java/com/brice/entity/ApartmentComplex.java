package com.brice.entity;

import lombok.Data;

/**
 * 小区实体类
 *
 * @author Brice
 * @date 2023/05/20
 */
@Data
public class ApartmentComplex {
    /**
     * id
     */
    private Long id;
    /**
     * 小区名称
     */
    private String acName;
}
