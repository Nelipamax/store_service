package ru.aston.store_service.dto;

import java.math.BigDecimal;
import java.util.UUID;


public class PaymentDto {

    private UUID orderId;

    private boolean isPaid;

    private BigDecimal totalCost;
}