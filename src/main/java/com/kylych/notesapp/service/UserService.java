package com.kylych.notesapp.service;

import com.kylych.notesapp.entity.User;
import com.kylych.notesapp.exception.ExceptionHandler;
import com.kylych.notesapp.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("User", "id", id));
    }


}
