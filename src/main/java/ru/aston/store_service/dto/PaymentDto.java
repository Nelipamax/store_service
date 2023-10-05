package ru.aston.store_service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
public class PaymentDto {

    private UUID orderId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean isPaid;

    private BigDecimal totalCost;
}