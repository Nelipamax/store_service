package ru.aston.store_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.aston.store_service.dto.OrderRequestDto;

import java.util.UUID;

@FeignClient(name = "order", url = "${feign.url.OrderServiceClient}")
public interface OrderServiceClient {

    @PostMapping(value = "/api/order/create")
    String sendOrderRequest(OrderRequestDto order);

    @PatchMapping("/payment/{transferId}")
    String sendPaymentBill(@PathVariable UUID transferId);
}
