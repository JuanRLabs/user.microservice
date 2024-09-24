package com.user.user.adapters.driven.jpa.mysql.mapper;

import com.user.user.adapters.driven.jpa.mysql.entity.UserEntity;
import com.user.user.domain.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IUserEntityMapper {

    UserEntity toEntity(User user);

}
