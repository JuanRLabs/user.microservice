package com.user.user.configuration;

import com.user.user.adapters.driven.jpa.mysql.adapter.EncoderAdapter;
import com.user.user.adapters.driven.jpa.mysql.adapter.UserAdapter;
import com.user.user.adapters.driven.jpa.mysql.mapper.IUserEntityMapper;
import com.user.user.adapters.driven.jpa.mysql.repository.IUserRepository;
import com.user.user.domain.api.IUserServicePort;
import com.user.user.domain.api.usecase.UserUseCase;
import com.user.user.domain.spi.IEncoderPersistencePort;
import com.user.user.domain.spi.IUserPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;

    @Bean
    public IUserPersistencePort userPersistencePort(){
        return new UserAdapter(userRepository, userEntityMapper);
    }

    @Bean
    public IUserServicePort userServicePort(){
        return new UserUseCase(userPersistencePort(), encoderPersistencePort());
    }

    @Bean
    public IEncoderPersistencePort encoderPersistencePort(){
        return new EncoderAdapter(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
