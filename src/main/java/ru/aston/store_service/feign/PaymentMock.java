package ru.aston.store_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.aston.store_service.dto.PaymentDto;

@FeignClient(name = "PaymentsMock", url = "localhost:8088")
public interface PaymentMock {

    @PostMapping(value = "/paymentmock")
    String sendPaymentRequest(@RequestBody PaymentDto bill);

    @PostMapping(value = "/stores/payments")
    String sendSuccesfullPaiedOrder(@RequestParam PaymentDto bill);

}

