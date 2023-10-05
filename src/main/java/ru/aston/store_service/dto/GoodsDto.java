package ru.aston.store_service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class GoodsDto {

    private Long productId;

    private String name;

    private int goodsQuantity;

    private BigDecimal price;
}
