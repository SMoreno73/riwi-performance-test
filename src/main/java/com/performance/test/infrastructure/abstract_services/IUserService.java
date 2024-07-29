package com.performance.test.infrastructure.abstract_services;

import com.performance.test.api.dto.request.UserRequest;
import com.performance.test.api.dto.response.UserResponse;
import com.performance.test.domain.entities.User;
import com.performance.test.infrastructure.abstract_services.generic.CreateService;

public interface IUserService extends
        CreateService<UserRequest, UserResponse>
{
    User getUserById(Long id);
}
