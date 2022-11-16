package com.brice.dto;

import com.brice.entity.SuppliesApply;
import lombok.Data;

@Data
public class SuppliesApplyDto extends SuppliesApply {
    private String residentName;
    private String residentPhone;
    private String acName;
    private String suppliesName;
}
