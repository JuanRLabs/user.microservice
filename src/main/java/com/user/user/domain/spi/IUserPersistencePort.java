package com.user.user.domain.spi;

import com.user.user.domain.model.User;

public interface IUserPersistencePort {

    void createAssistantWarehouse(User user);

}
