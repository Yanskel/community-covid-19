package com.brice.dto;

import com.brice.entity.HealthInfo;

import lombok.Data;

/**
 * 健康信息dto
 *
 * @author Brice
 * @date 2023/05/20
 */
@Data
public class HealthInfoDto extends HealthInfo {
    /**
     * 居民电话
     */
    private String residentPhone;
    /**
     * 小区名称
     */
    private String acName;
    /**
     * 地址
     */
    private String address;
}
