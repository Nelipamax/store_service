package ru.aston.store_service.dto;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record OrderRequestDto(
        UUID id,
        Long userId,
        Long storeId,
        Float totalPrice,
        Instant deliveryDatetime,
        String deliveryAddress,
        List<GoodDto> goods) {

    public record GoodDto(
            Long productId,
            Long goodsQuantity) {
    }
}
