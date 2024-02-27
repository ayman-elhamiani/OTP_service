package com.ayman.client_otp.otp_service.service;


import com.bastiaanjansen.otp.HMACAlgorithm;
import com.bastiaanjansen.otp.HOTPGenerator;
import com.bastiaanjansen.otp.SecretGenerator;
import com.bastiaanjansen.otp.TOTPGenerator;
import com.ayman.client_otp.otp_service.repository.OtpRepository;
import org.springframework.stereotype.Service;


import java.time.Duration;

@Service
public class OtpGenerateService {

    public String generateOtp( byte[] secret){


        TOTPGenerator totp = new TOTPGenerator.Builder(secret)
                .withHOTPGenerator(builder -> {
                    builder.withPasswordLength(6);
                    builder.withAlgorithm(HMACAlgorithm.SHA256); // SHA256 and SHA512 are also supported
                })
                .withPeriod(Duration.ofMinutes(15))
                .build();

        // Store the UUID along with the TOTP instance (for later verification)

    return totp.now();
    }






}
