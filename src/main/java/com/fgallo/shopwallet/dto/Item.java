package com.fgallo.shopwallet.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class Item {
    private String code;
    private String description;
    private BigDecimal price;

}
