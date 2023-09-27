package ru.aston.store_service.dto;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class GoodsDto {

    private Long id;

    private String name;

    private int count;

    private BigDecimal price;
}
