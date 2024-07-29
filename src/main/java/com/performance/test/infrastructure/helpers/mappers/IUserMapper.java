package com.performance.test.infrastructure.helpers.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.performance.test.api.dto.request.UserRequest;
import com.performance.test.api.dto.response.UserResponse;
import com.performance.test.domain.entities.User;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IUserMapper {
    @Mapping(target = "id", ignore = true)
    User toUser(UserRequest userRequest);

    UserResponse toUserResponse(User user);
}
