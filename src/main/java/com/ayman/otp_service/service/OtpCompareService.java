package com.ayman.otp_service.service;


import com.ayman.otp_service.model.OtpStatus;
import org.springframework.stereotype.Service;

@Service
public class OtpCompareService {
    public OtpStatus compareOtp(String userInput) {
        // Compare user input with the stored OTP
        // Return true if they match, false otherwise


        OtpStatus expiration;


        try {
            boolean isCodeValid = OtpGenerateService.totp.verify(userInput);
            if (isCodeValid) {
                expiration = OtpStatus.PENDING;
            } else {
                expiration = OtpStatus.EXPIRED;
            }
            // Or verify with a delay window
        } catch (IllegalStateException e) {
            // Handle error
            expiration = OtpStatus.FAILED;
        }

//        OtpPhone otpPhone = OtpPhone.builder()
//                .phoneNum(request.getPhoneNumber())
//                .code(code)
//                .status(expiration)
//                .build();
//
//        this.otpPhoneRepository.save(otpPhone);

        return expiration;
    }

}
