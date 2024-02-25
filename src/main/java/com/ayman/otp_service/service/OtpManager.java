package com.ayman.otp_service.service;

import com.bastiaanjansen.otp.TOTPGenerator;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class OtpManager {

        private Map<UUID, TOTPGenerator> totpMap = new HashMap<>();

        public UUID generateUuid() {
            return UUID.randomUUID();
        }

        public void storeOtpInstance(UUID userId, TOTPGenerator totp) {
            totpMap.put(userId, totp);
        }

        public TOTPGenerator retrieveOtpInstance(UUID userId) {
            return totpMap.get(userId);
        }


}