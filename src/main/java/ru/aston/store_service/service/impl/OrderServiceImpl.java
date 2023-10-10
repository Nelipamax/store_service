package ru.aston.store_service.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aston.store_service.dto.GoodsDto;
import ru.aston.store_service.dto.OrderRequestDto;
import ru.aston.store_service.dto.PaymentDto;
import ru.aston.store_service.feign.OrderServiceClient;
import ru.aston.store_service.feign.PaymentServiceClient;
import ru.aston.store_service.service.OrderService;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderServiceClient orderServiceClient;
    private final PaymentServiceClient paymentServiceClient;

    @Override
    public OrderRequestDto createOrderRequest(Long clientId, Long storeId, String deliveryAddress, LocalDateTime deliveryTime, List<GoodsDto> goods) {
        UUID orderId = UUID.randomUUID();
        List<OrderRequestDto.GoodDto> goodsList = new ArrayList<>();
        BigDecimal totalPrice = BigDecimal.valueOf(0.00);
        for (GoodsDto good : goods) {
            totalPrice = totalPrice.add(good.price().multiply(BigDecimal.valueOf(good.goodsQuantity())));
            goodsList.add(new OrderRequestDto.GoodDto(good.productId(), good.goodsQuantity()));
        }

        return new OrderRequestDto(orderId, clientId, storeId, Float.valueOf(totalPrice.toString()), Instant.from(deliveryTime), deliveryAddress, goodsList);
    }

    @Override
    public String sendToOrderService(OrderRequestDto order) {
        return orderServiceClient.sendOrderRequest(order);
    }

    @Override
    public String sendToPaymentService() {
        return null;
    }

    @Override
    public String sendPaymentBillToOrderService(PaymentDto bill) {
        return orderServiceClient.sendPaymentBill(bill.orderId());
    }


}
