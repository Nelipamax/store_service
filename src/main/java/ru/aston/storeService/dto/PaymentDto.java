package ru.aston.storeService.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.util.UUID;

public record PaymentDto(UUID orderId, @JsonInclude(JsonInclude.Include.NON_NULL) boolean isPaid,
                         BigDecimal totalCost) {

}