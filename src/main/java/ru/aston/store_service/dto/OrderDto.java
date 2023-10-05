package ru.aston.store_service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class OrderDto {

    UUID id;

    Long userId;

    Long storeId;

    BigDecimal totalPrice;

    LocalDateTime deliveryDatetime;

    String deliveryAddress;

    List<GoodsDto> goods;
}
