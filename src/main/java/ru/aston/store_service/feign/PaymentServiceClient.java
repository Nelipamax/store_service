package ru.aston.store_service.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "PaymentServiceClient", url = "${feign.url.PaymentServiceClient}")
public interface PaymentServiceClient {

}
