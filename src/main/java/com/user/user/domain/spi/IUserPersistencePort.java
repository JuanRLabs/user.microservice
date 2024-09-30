package com.user.user.domain.spi;

import com.user.user.domain.model.User;

public interface IUserPersistencePort {

    void createAssistantWarehouse(User user);
    boolean existsUser(String dni);
    boolean existsUserEmail(String email);
}
