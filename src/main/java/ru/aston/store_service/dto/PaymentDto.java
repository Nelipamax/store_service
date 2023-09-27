package ru.aston.store_service.dto;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class PaymentDto {

    private UUID orderId;

    private boolean isPaid;

    private BigDecimal totalCost;
}