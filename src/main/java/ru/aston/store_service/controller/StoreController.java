package ru.aston.store_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.aston.store_service.dto.GoodsDto;
import ru.aston.store_service.dto.OrderRequestDto;
import ru.aston.store_service.dto.PaymentDto;
import ru.aston.store_service.dto.StoreDto;
import ru.aston.store_service.service.GoodsService;
import ru.aston.store_service.service.OrderService;
import ru.aston.store_service.service.StoreService;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/stores")
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

    @PostMapping
    ResponseEntity<Integer> reduceQuantitiesOfGoods(@RequestBody List<GoodsDto> goodsDtoList) {
        return ResponseEntity.ok(goodsService.reduceQuantity(goodsDtoList));
    }

    @PostMapping(value = "/{storeId}/order")
    public OrderRequestDto createOrder(@PathVariable(value = "storeId") Long storeId,
                                @RequestParam Long clientId,
                                @RequestParam List<GoodsDto> goods,
                                @RequestParam String deliveryAddress,
                                @RequestParam LocalDateTime deliveryTime) {

        OrderRequestDto order = orderService.createOrderRequest(clientId, storeId, deliveryAddress, deliveryTime, goods);
        orderService.sendToOrderService(order);
        orderService.sendToPaymentMockService(order);
        return order;
    }

    @PostMapping("/payments")
    public String getPaymentBill(@RequestParam PaymentDto bill) {

        orderService.sendPaymentBillToOrderService(bill);

        return "Чек об оплате успешно принят";
    }
}