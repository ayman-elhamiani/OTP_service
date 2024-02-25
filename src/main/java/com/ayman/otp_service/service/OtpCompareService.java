package com.ayman.otp_service.service;


import com.ayman.otp_service.model.OtpStatus;
import org.springframework.stereotype.Service;

@Service
public class OtpCompareService {
    public Boolean compareOtp(String userInput) {
        // Compare user input with the stored OTP
        // Return true if they match, false otherwise






         boolean isCodeValid = OtpGenerateService.totp.verify(userInput);

        return isCodeValid;
    }

}
