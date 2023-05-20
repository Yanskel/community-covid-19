package com.brice.dto;

import com.brice.entity.SuppliesApply;

import lombok.Data;

/**
 * 物资申请dto
 *
 * @author Brice
 * @date 2023/05/20
 */
@Data
public class SuppliesApplyDto extends SuppliesApply {
    /**
     * 居民名字
     */
    private String residentName;
    /**
     * 居民电话
     */
    private String residentPhone;
    /**
     * 小区名称
     */
    private String acName;
    /**
     * 物资名称
     */
    private String suppliesName;
    /**
     * 地址
     */
    private String address;
}
