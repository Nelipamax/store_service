package ru.aston.storeService.service;

import ru.aston.storeService.dto.GoodsDto;
import ru.aston.storeService.dto.OrderRequestDto;
import ru.aston.storeService.dto.PaymentDto;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {
    OrderRequestDto createOrderRequest(Long clientId, Long storeId, String deliveryAddress, LocalDateTime deliveryTime, List<GoodsDto> goods);
    String sendToOrderService(OrderRequestDto order);
    String sendToPaymentService();
    String sendPaymentBillToOrderService(PaymentDto bill);
    public String sendToPaymentMockService(OrderRequestDto order);
}
