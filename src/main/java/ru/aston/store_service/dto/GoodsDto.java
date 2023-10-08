package ru.aston.store_service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
public class GoodsDto {
    private UUID productId;

    private int storeId;

    private String name;

    private int goodsQuantity;

    private BigDecimal price;
}
