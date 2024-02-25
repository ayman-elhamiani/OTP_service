package com.ayman.otp_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OtpPhoneRequest {

    private String phoneNumber;
    private String userInput;
    private UUID userId;



    // Constructors, getters, setters
}
