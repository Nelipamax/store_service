package ru.aston.store_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/*import ru.aston.store_service.dto.FromGoodsDto;*/
import ru.aston.store_service.dto.GoodsDto;
import ru.aston.store_service.dto.OrderDto;

import java.util.List;

@FeignClient(name = "goods", url = "${feign.url.goods}")
public interface GoodsServiceClient {

    /*@RequestLine("GET /goods/{storeId}")*/
    @GetMapping(value = "/goods/{storeId}")
    String getAllGoodsFromStoreWithId(/*@Param("storeId")*/ @PathVariable Long storeId);

    @PostMapping(value = "/goods{storeId}")
    boolean sendPayedOrder(@PathVariable(value = "storeId") Long storeId, OrderDto order);

    @PostMapping(value = "/goods")
    ResponseEntity<Integer> reduceQuantities(@RequestBody List<GoodsDto> goodsDtoList);
}