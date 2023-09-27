package ru.aston.store_service.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.aston.store_service.dto.GoodsDto;

import java.util.List;

@FeignClient(value = "GoodsServiceClient", url = "https://goodsservice.ru/")
public interface GoodsServiceClient {

    @GetMapping(value = "/goods{storeId}", produces = "application/json")
    List<GoodsDto> goods(@PathVariable String storeId);
}
