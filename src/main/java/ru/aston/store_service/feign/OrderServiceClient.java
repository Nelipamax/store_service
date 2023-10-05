package ru.aston.store_service.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "OrderServiceClient", url = "https://orderservice.ru/")
public interface OrderServiceClient {


}
