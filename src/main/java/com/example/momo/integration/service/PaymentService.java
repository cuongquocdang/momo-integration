package com.example.momo.integration.service;

import com.example.momo.integration.dto.request.PaymentRequest;
import com.example.momo.integration.dto.response.PaymentResponse;

public interface PaymentService {

    PaymentResponse payment(PaymentRequest request) throws Exception;

}
