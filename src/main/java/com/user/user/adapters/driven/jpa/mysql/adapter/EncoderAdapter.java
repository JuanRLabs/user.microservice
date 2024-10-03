package com.user.user.adapters.driven.jpa.mysql.adapter;

import com.user.user.domain.spi.IEncoderPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class EncoderAdapter implements IEncoderPersistencePort {

    private final PasswordEncoder passwordEncoder;

    @Override
    public String encode(String password) {
        return passwordEncoder.encode(password);
    }
}
