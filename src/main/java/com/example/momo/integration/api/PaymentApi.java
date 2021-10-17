package com.example.momo.integration.api;

import com.example.momo.integration.dto.request.PaymentRequest;
import com.example.momo.integration.dto.response.BaseRestResponse;
import com.example.momo.integration.dto.response.PaymentResponse;
import com.example.momo.integration.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
public class PaymentApi {

    private final PaymentService paymentService;

    @Autowired
    public PaymentApi(@Qualifier("momoPaymentService") PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/momo")
    public ResponseEntity<?> payment(@RequestBody PaymentRequest request) {
        try {
            PaymentResponse response = paymentService.payment(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception exception) {
            BaseRestResponse response = BaseRestResponse.builder()
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .success(false)
                    .message("An exception occurs when process payment.")
                    .buildResponse();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
