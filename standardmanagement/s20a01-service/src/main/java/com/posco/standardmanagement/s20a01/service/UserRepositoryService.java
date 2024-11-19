package com.posco.standardmanagement.s20a01.service;

import com.posco.standardmanagement.s20a01.domain.user.RegisterUserCommand;
import com.posco.standardmanagement.s20a01.domain.user.User;
import com.posco.standardmanagement.s20a01.domain.user.UserRepository;
import com.posco.standardmanagement.s20a01.domain.user.mybatis.UserMapper;
import com.posco.standardmanagement.s20a01.domain.user.mybatis.UserMybatisEntity;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional
public class UserRepositoryService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserRepositoryService(
        UserRepository userRepository,
        UserMapper userMapper
    ) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public User create(RegisterUserCommand command) {
        User user = new User();
        user.setUsername(command.getUsername());
        user.setEmail(command.getEmail());
        user.setPhoneNumber(command.getPhoneNumber());
        return userRepository.save(user);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        return userRepository
            .findById(id)
            .orElseThrow(() ->
                new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "User not found"
                )
            );
    }

    //// mybatis
    private User convertToEntity(UserMybatisEntity mybatisEntity) {
        User entity = new User();
        return entity;
    }

    private UserMybatisEntity convertToMybatisEntity(User entity) {
        UserMybatisEntity mybatisEntity = new UserMybatisEntity();
        return mybatisEntity;
    }
    // 예시
    // public List<User> findAllByMapper() {
    //     return mybatisMapper.selectUserList().stream()
    //         .map(this::convertToEntity)
    //         .collect(Collectors.toList());
    // }

    // public User findByIdMapper(String id) {
    //     UserMybatisEntity mybatisEntity = mybatisMapper.selectUser(id);
    //     if (mybatisEntity == null) {
    //         throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
    //     }
    //     return convertToEntity(mybatisEntity);
    // }
}
