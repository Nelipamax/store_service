package ru.aston.store_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.aston.store_service.dto.GoodsDto;
import ru.aston.store_service.dto.OrderDto;
import ru.aston.store_service.dto.StoreDto;
import ru.aston.store_service.service.GoodsService;
import ru.aston.store_service.service.OrderService;
import ru.aston.store_service.service.StoreService;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController(value = "/stores")
public class StoreController {

    private final StoreService storeService;
    private final GoodsService goodsService;
    private final OrderService orderService;

    @GetMapping
    public List<StoreDto> getStores() {
        return storeService.getStores();
    }

    @GetMapping(value = "/{storeId}/goods")
    public List<GoodsDto> getGoods(@PathVariable(value = "storeId") Long storeId) {

        return goodsService.getGoodsFromStore(storeId);
    }

    @PostMapping(value = "/{storeId}/order")
    public OrderDto createOrder(@PathVariable(value = "storeId") Long storeId,
                                @RequestParam List<GoodsDto> goods,
                                @RequestParam LocalDateTime deliveryTime) {

        return null;
    }
}
