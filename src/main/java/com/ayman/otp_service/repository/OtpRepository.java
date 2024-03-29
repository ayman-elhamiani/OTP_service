package com.ayman.otp_service.repository;


import com.ayman.otp_service.model.Otp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtpRepository extends JpaRepository<Otp, Long> {
    // Additional query methods if needed
}
