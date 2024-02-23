package com.ayman.otp_service.service;


import com.ayman.otp_service.dto.OtpPhoneRequest;
import com.bastiaanjansen.otp.HMACAlgorithm;
import com.bastiaanjansen.otp.SecretGenerator;
import com.bastiaanjansen.otp.TOTPGenerator;
import com.ayman.otp_service.repository.OtpRepository;
import org.springframework.stereotype.Service;


import java.time.Duration;
@Service
public class OtpGenerateService {

    private OtpRepository otpPhoneRepository;
    static TOTPGenerator totp;

    public String generateOtp(){
        byte[] secret = SecretGenerator.generate();

        this.totp = new TOTPGenerator.Builder(secret)
                .withHOTPGenerator(builder -> {
                    builder.withPasswordLength(6);
                    builder.withAlgorithm(HMACAlgorithm.SHA256); // SHA256 and SHA512 are also supported
                })
                .withPeriod(Duration.ofMinutes(15))
                .build();

        String code = this.totp.now();
        return (code);
    }






}
