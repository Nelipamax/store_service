package ru.aston.store_service.dto;

import java.math.BigDecimal;

public record GoodsDto(Long productId, Long storeId, String name, Long goodsQuantity, BigDecimal price) {
}
