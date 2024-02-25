package com.ayman.otp_service.controller;

import com.ayman.otp_service.dto.OtpPhoneRequest;
import com.ayman.otp_service.service.OtpCompareService;
import com.ayman.otp_service.service.OtpManager;
import com.ayman.otp_service.service.OtpGenerateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/otp")
public class OtpPhoneController {

    private final OtpGenerateService otpGenerateService;
    private final OtpCompareService otpCompareService;
    private final OtpManager otpManager;



    @Autowired
    public OtpPhoneController(OtpGenerateService otpService,
                              OtpManager otpManager,
                              OtpCompareService otpCompareService) {
        this.otpGenerateService = otpService;
        this.otpCompareService = otpCompareService;
        this.otpManager = otpManager;
    }

    @PostMapping("/generate")
    public ResponseEntity<Object> generatePhoneOtp() {
        UUID userId = otpManager.generateUuid();
        String generatedOtp = otpGenerateService.generateOtp(userId);
        System.out.println("User ID for the session: " + userId);
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("userId", userId.toString());
        responseMap.put("generatedOtp", generatedOtp);

        // Return the JSON object in the response body
        return ResponseEntity.ok(responseMap);    }





    @PostMapping("/compare")
    public ResponseEntity<Boolean> compareOtp(@RequestBody OtpPhoneRequest otpPhoneRequest) {
        // Use the UUID associated with the user to verify the OTP
        boolean isOtpValid = otpCompareService.compareOtp(otpPhoneRequest.getUserInput(), otpPhoneRequest.getUserId());

        return ResponseEntity.ok(isOtpValid);
    }
}