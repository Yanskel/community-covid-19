package com.brice.dto;

import com.brice.entity.Supplies;
import lombok.Data;

@Data
public class SuppliesDto extends Supplies {
    private String categoryName;
}
