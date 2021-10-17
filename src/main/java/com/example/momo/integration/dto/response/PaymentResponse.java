package com.example.momo.integration.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaymentResponse {
    private String requestId;
    private int errorCode;
    private String message;
    private String localMessage;
    private String requestType;
    private String payUrl;
    private String signature;
    private String qrCodeUrl;
    private String deeplink;
    private String deeplinkWebInApp;
}
