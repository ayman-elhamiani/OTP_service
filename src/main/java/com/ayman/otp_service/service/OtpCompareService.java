package com.ayman.otp_service.service;


import com.ayman.otp_service.model.OtpStatus;
import com.bastiaanjansen.otp.TOTPGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class OtpCompareService {
    private OtpManager otpManager;

    @Autowired
    public OtpCompareService(OtpManager otpManager) {
        this.otpManager = otpManager;
    }

    public Boolean compareOtp(String userInput, UUID userId) {
        // Retrieve the stored TOTP instance for the given user
        TOTPGenerator totp = otpManager.retrieveOtpInstance(userId);

        // Perform OTP verification
        boolean isCodeValid = totp.verify(userInput);

        return isCodeValid;
    }

}
