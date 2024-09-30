package com.user.user.domain.api.usecase;

import com.user.user.domain.exception.UserAlreadyExistException;
import com.user.user.domain.model.Role;
import com.user.user.domain.model.User;
import com.user.user.domain.spi.IUserPersistencePort;
import com.user.user.domain.validation.ValidateUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserUseCaseTest {

        @Mock
        private IUserPersistencePort persistencePort;

        @Mock
        private ValidateUser validateUser;

        @InjectMocks
        private UserUseCase userUseCase;

        @Test
        void testCreateAssistantWarehouse_UserAlreadyExists_ThrowsUserAlreadyExistException() {
            // Arrange
            Role roleAux = new Role(2L, "ROLE_AUXILIAR", "ROLE_AUXILIAR");
            User user = new User("name", "surname","2323455","3002004010", "2000-08-08", "name@email.com", "string", roleAux);
            when(persistencePort.existsUser(user.getDni().trim())).thenReturn(true);
            when(persistencePort.existsUserEmail(user.getEmail())).thenReturn(true);

            // Act and Assert
            assertThrows(UserAlreadyExistException.class, () -> userUseCase.createAssistantWarehouse(user));
        }

        @Test
        void testCreateAssistantWarehouse_ValidUser_CreatesAssistantWarehouse() {
            // Arrange
            Role roleAux = new Role(2L, "ROLE_AUXILIAR", "ROLE_AUXILIAR");
            User user = new User("", "surname","484848","3002004010", "2000-08-08", "name@email.com", "string", roleAux);
            when(persistencePort.existsUser(user.getDni().trim())).thenReturn(false);
            when(persistencePort.existsUserEmail(user.getEmail())).thenReturn(false);
            //when(validateUser.validateUserInput(user)).thenReturn(true);

            // Act
            userUseCase.createAssistantWarehouse(user);

            // Assert
            verify(persistencePort).createAssistantWarehouse(user);
            verify(user).setIdRole(roleAux);
        }

        @Test
        void testCreateAssistantWarehouse_InvalidUser_ThrowsException() {
            // Arrange
            Role roleAux = new Role(2L, "ROLE_AUXILIAR", "ROLE_AUXILIAR");
            User user = new User("", "surname","484848","3002004010", "2000-08-08", "name@email.com", "string", roleAux);
            //when(validateUser.validateUserInput(user)).thenThrow(new RuntimeException("Invalid user"));

            // Act and Assert
            assertThrows(RuntimeException.class, () -> userUseCase.createAssistantWarehouse(user));
        }

        @Test
        void testCreateAssistantWarehouse_ValidUserButInvalidDni_ThrowsException() {
            // Arrange
            Role roleAux = new Role(2L, "ROLE_AUXILIAR", "ROLE_AUXILIAR");
            User user = new User("", "surname","s4848s48","3002004010", "2000-08-08", "name@email.com", "string", roleAux);
            //when(validateUser.validateUserInput(user)).thenReturn(false);

            // Act and Assert
            assertThrows(RuntimeException.class, () -> userUseCase.createAssistantWarehouse(user));
        }

        @Test
        void testCreateAssistantWarehouse_ValidUserButInvalidEmail_ThrowsException() {
            // Arrange
            Role roleAux = new Role(2L, "ROLE_AUXILIAR", "ROLE_AUXILIAR");
            User user = new User("", "surname","s4848s48","3002004010", "2000-08-08", "nameemail.com", "string", roleAux);
            //when(validateUser.validateUserInput(user)).thenReturn(false);

            // Act and Assert
            assertThrows(RuntimeException.class, () -> userUseCase.createAssistantWarehouse(user));
        }

}