package ru.aston.storeService.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record OrderDto(UUID id, Long userId, Long storeId, BigDecimal totalPrice, LocalDateTime deliveryDatetime,
                       String deliveryAddress, List<GoodsDto> goods) {

}
