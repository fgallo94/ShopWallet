package com.fgallo.shopwallet.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Category {
    private String code;
    private String description;
}
