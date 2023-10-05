package ru.aston.store_service.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "PaymentServiceClient", url = "https://paymentservice.ru/")
public interface PaymentServiceClient {
}
