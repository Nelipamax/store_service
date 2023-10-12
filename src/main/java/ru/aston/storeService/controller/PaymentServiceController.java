package ru.aston.storeService.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.aston.storeService.dto.PaymentDto;
import ru.aston.storeService.feign.PaymentMock;

import java.util.Random;

@RestController
@RequiredArgsConstructor
public class PaymentServiceController {

    private final PaymentMock paymentMock;

    @PostMapping(value = "/paymentmock")
    public String getOrderToPayment(@RequestBody PaymentDto bill) {

        Random r = new Random();
        int x = r.nextInt(10);
        if (x > 3) {
           PaymentDto dto = new PaymentDto(bill.orderId(), true, bill.totalCost());
            paymentMock.sendSuccesfullPaiedOrder(dto);
        }

        return "Заказ принят к оплате";
    }
}
