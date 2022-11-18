package com.brice.dto;

import com.brice.entity.HealthInfo;
import lombok.Data;

@Data
public class HealthInfoDto extends HealthInfo {
    private String residentPhone;
    private String acName;
}
