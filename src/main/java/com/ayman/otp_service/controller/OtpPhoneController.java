package com.ayman.otp_service.controller;

import com.ayman.otp_service.dto.OtpPhoneRequest;
import com.ayman.otp_service.model.OtpStatus;
import com.ayman.otp_service.service.OtpCompareService;
import com.ayman.otp_service.service.OtpSendPhoneService;
import com.ayman.otp_service.service.OtpGenerateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/otp")
public class OtpPhoneController {

    private final OtpGenerateService otpGenerateService;
    private final OtpSendPhoneService otpSendPhoneService;
    private final OtpCompareService otpCompareService;



    @Autowired
    public OtpPhoneController(OtpGenerateService otpService,
                              OtpSendPhoneService otpSendPhoneService,
                              OtpCompareService otpCompareService) {
        this.otpGenerateService = otpService;
        this.otpSendPhoneService = otpSendPhoneService;
        this.otpCompareService = otpCompareService;
    }

    @PostMapping("/generate")
    public String generatePhoneOtp(@RequestBody OtpPhoneRequest phoneNumber) {
        String generatedOtp = otpGenerateService.generateOtp();
//        sendOtpPhone(generatedOtp, phoneNumber.getPhoneNumber() );
        return generatedOtp;
    }



//    @PostMapping("/send-phone")
//    public void sendOtpPhone(@RequestParam String otp, @RequestParam String phoneNumber) {
//        otpSendPhoneService.sendOtpPhone(otp, phoneNumber);
//    }

    @PostMapping("/compare")
    public Boolean compareOtp(@RequestBody OtpPhoneRequest userInput) {
        return otpCompareService.compareOtp(userInput.getUserInput());
    }
}