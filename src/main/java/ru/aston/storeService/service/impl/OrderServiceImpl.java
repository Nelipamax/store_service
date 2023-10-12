package ru.aston.storeService.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aston.storeService.dto.GoodsDto;
import ru.aston.storeService.dto.OrderRequestDto;
import ru.aston.storeService.dto.PaymentDto;
import ru.aston.storeService.feign.OrderServiceClient;
import ru.aston.storeService.feign.PaymentMock;
import ru.aston.storeService.feign.PaymentServiceClient;
import ru.aston.storeService.service.OrderService;

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
    private final PaymentMock paymentMock;

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
    public String sendToPaymentMockService(OrderRequestDto order) {
        return paymentMock.sendPaymentRequest(new PaymentDto(order.id(), false, BigDecimal.valueOf(order.totalPrice())));
    }

    @Override
    public String sendPaymentBillToOrderService(PaymentDto bill) {
        return orderServiceClient.sendPaymentBill(bill.orderId());
    }


}
