package com.user.user.adapters.driven.jpa.mysql.adapter;

import com.user.user.adapters.driven.jpa.mysql.entity.UserEntity;
import com.user.user.adapters.driven.jpa.mysql.mapper.IUserEntityMapper;
import com.user.user.adapters.driven.jpa.mysql.repository.IUserRepository;
import com.user.user.domain.model.User;
import com.user.user.domain.spi.IUserPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserAdapter implements IUserPersistencePort {

    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;


    @Override
    public void createAssistantWarehouse(User user) {
        userRepository.save(userEntityMapper.toEntity(user));
    }

    @Override
    public boolean existsUser(String dni) {
      UserEntity optional = userRepository.findByDni(dni);
        return optional == null;
    }

    @Override
    public boolean existsUserEmail(String email ) {
        UserEntity optional = userRepository.findByEmail(email);
        return optional == null;
    }

}
