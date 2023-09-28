package ru.aston.store_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.aston.store_service.dto.GoodsDto;
import ru.aston.store_service.dto.OrderDto;
import ru.aston.store_service.dto.StoreDto;
import ru.aston.store_service.service.StoreService;

import java.time.LocalDateTime;
import java.util.List;

@RestController(value = "/stores")
public class StoreController {

    private final StoreService service;

    @GetMapping
    public List<StoreDto> getStores() {
        return service.getStores();
    }

    @GetMapping(value = "/{storeId}/goods")
    public List<GoodsDto> getGoods() {
        return null;
    }

    @PostMapping(value = "/{storeId}/order")
    public OrderDto createOrder(@RequestParam List<GoodsDto> goods,
                                @RequestParam LocalDateTime deliveryTime) {
        return null;
    }

    public StoreController(StoreService service) {
        this.service = service;
    }
}
