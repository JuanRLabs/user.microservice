package com.user.user.adapters.driving.mapper;

import com.user.user.adapters.driving.dto.AddUserAssistant;
import com.user.user.domain.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IUserRequestMapper {

    User toModel(AddUserAssistant addUserAssistant);
}
