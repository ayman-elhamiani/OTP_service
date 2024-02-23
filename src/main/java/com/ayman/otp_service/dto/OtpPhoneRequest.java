package com.ayman.otp_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OtpPhoneRequest {

    private String phoneNumber;
    private String userInput;


    // Constructors, getters, setters
}
