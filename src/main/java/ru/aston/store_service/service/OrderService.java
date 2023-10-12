package ru.aston.store_service.service;

import ru.aston.store_service.dto.GoodsDto;
import ru.aston.store_service.dto.OrderRequestDto;
import ru.aston.store_service.dto.PaymentDto;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {
    OrderRequestDto createOrderRequest(Long clientId, Long storeId, String deliveryAddress, LocalDateTime deliveryTime, List<GoodsDto> goods);
    String sendToOrderService(OrderRequestDto order);
    String sendToPaymentService();
    String sendPaymentBillToOrderService(PaymentDto bill);
    public String sendToPaymentMockService(OrderRequestDto order);
}
