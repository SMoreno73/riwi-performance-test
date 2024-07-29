package com.performance.test.infrastructure.services;

import com.performance.test.api.dto.request.UserRequest;
import com.performance.test.api.dto.response.UserResponse;
import com.performance.test.domain.entities.User;
import com.performance.test.domain.repositories.UserRepository;
import com.performance.test.infrastructure.abstract_services.IUserService;
import com.performance.test.util.exeptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    @Autowired
    private final UserRepository userRepository;

    @Override
    public UserResponse create(UserRequest userRequest) {
        return null;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("USER", id));
    }
}
