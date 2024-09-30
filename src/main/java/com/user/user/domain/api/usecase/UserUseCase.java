package com.user.user.domain.api.usecase;

import com.user.user.domain.api.IUserServicePort;
import com.user.user.domain.exception.UserAlreadyExistException;
import com.user.user.domain.model.Role;
import com.user.user.domain.model.User;
import com.user.user.domain.spi.IUserPersistencePort;
import com.user.user.domain.validation.ConstantsDomain;
import com.user.user.domain.validation.ValidateUser;

public class UserUseCase implements IUserServicePort {

    private final IUserPersistencePort persistencePort;

    public UserUseCase(IUserPersistencePort persistencePort) {
        this.persistencePort = persistencePort;
    }

    @Override
    public void createAssistantWarehouse(User user) {
        ValidateUser.validateUserInput(user);
        if(persistencePort.existsUser(user.getDni().trim()) && persistencePort.existsUserEmail(user.getEmail())){
        Role roleAux = new Role(2L, "ROLE_AUXILIAR", "ROLE_AUXILIAR");
        user.setIdRole(roleAux);
        persistencePort.createAssistantWarehouse(user);
        }else{
            throw new UserAlreadyExistException(ConstantsDomain.USER_ALREADY_EXISTS_MESSAGE);
        }

    }
}
