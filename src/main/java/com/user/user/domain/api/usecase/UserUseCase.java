package com.user.user.domain.api.usecase;

import com.user.user.domain.api.IUserServicePort;
import com.user.user.domain.model.User;
import com.user.user.domain.spi.IUserPersistencePort;

public class UserUseCase implements IUserServicePort {

    private final IUserPersistencePort persistencePort;

    public UserUseCase(IUserPersistencePort persistencePort) {
        this.persistencePort = persistencePort;
    }

    @Override
    public void createAssistantWarehouse(User user) {
        persistencePort.createAssistantWarehouse(user);
    }
}
