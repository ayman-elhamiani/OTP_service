package com.ayman.otp_service.service;


import com.ayman.otp_service.dto.OtpPhoneRequest;
import com.bastiaanjansen.otp.HMACAlgorithm;
import com.bastiaanjansen.otp.SecretGenerator;
import com.bastiaanjansen.otp.TOTPGenerator;
import com.ayman.otp_service.repository.OtpRepository;
import org.springframework.stereotype.Service;


import java.time.Duration;
import java.util.UUID;

@Service
public class OtpGenerateService {

    private OtpRepository otpPhoneRepository;
    private OtpManager otpManager;

    public OtpGenerateService(OtpRepository otpPhoneRepository, OtpManager otpManager) {
        this.otpPhoneRepository = otpPhoneRepository;
        this.otpManager = otpManager;
    }
    public String generateOtp( UUID userId){
        byte[] secret = SecretGenerator.generate();

        TOTPGenerator totp = new TOTPGenerator.Builder(secret)
                .withHOTPGenerator(builder -> {
                    builder.withPasswordLength(6);
                    builder.withAlgorithm(HMACAlgorithm.SHA256); // SHA256 and SHA512 are also supported
                })
                .withPeriod(Duration.ofMinutes(15))
                .build();

        // Store the UUID along with the TOTP instance (for later verification)
        otpManager.storeOtpInstance(userId, totp);


        String code = totp.now();
        return (code);
    }






}
