package com.brice.dto;

import com.brice.entity.Supplies;

import lombok.Data;

/**
 * 物资dto
 *
 * @author Brice
 * @date 2023/05/20
 */
@Data
public class SuppliesDto extends Supplies {
    /**
     * 分类名称
     */
    private String categoryName;
}
