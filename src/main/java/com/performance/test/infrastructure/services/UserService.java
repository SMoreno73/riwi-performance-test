package com.performance.test.infrastructure.services;

import com.performance.test.api.dto.request.UserRequest;
import com.performance.test.api.dto.response.UserResponse;
import com.performance.test.domain.entities.User;
import com.performance.test.domain.repositories.UserRepository;
import com.performance.test.infrastructure.abstract_services.IUserService;
import com.performance.test.infrastructure.helpers.mappers.IUserMapper;
import com.performance.test.util.exeptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final IUserMapper userMapper;

    @Override
    public UserResponse create(UserRequest userRequest) {
        User user = this.userMapper.toUser(userRequest);
        return this.userMapper.toUserResponse(this.userRepository.save(user));
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("USER", id));
    }
}
