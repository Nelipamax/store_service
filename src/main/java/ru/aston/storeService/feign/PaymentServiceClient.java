package ru.aston.storeService.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.aston.storeService.dto.PaymentDto;

import java.util.UUID;

@FeignClient(name = "PaymentServiceClient", url = "${feign.url.PaymentServiceClient}")
public interface PaymentServiceClient {

    @PostMapping("/pay/{orderId}")
    public String sendOrderToPay(@PathVariable UUID orderId, @RequestBody PaymentDto bill);
}
