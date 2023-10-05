package ru.aston.store_service.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.aston.store_service.dto.GoodsDto;
import ru.aston.store_service.dto.OrderDto;

import java.util.List;

@FeignClient(value = "GoodsServiceClient", url = "https://goodsservice.ru/")
public interface GoodsServiceClient {

    @GetMapping(value = "/goods/{storeId}", produces = "application/json")
    List<GoodsDto> goods(@PathVariable(value = "storeId") Long storeId);

    @PostMapping(value = "/goods{storeId}")
    boolean sendPayedOrder(@PathVariable(value = "storeId") Long storeId,
                           OrderDto order);
}
