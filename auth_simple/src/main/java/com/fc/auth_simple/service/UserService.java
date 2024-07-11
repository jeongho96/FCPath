package com.fc.auth_simple.service;


import com.fc.auth_simple.db.UserRepository;
import com.fc.auth_simple.model.LoginRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void login(
            LoginRequest loginRequest,
            HttpSession httpSession
    ){
        var id = loginRequest.getId();
        var pw = loginRequest.getPassword();


        var optionalUser = userRepository.findByName(id);

        if(optionalUser.isPresent()) {
            var userDto = optionalUser.get();

            if(userDto.getPassword().equals(pw)) {
                // 세션에 정보저장
                httpSession.setAttribute("user", userDto);

            }else{
                throw new RuntimeException("Password Not Match");
            }
        }else{
            throw new RuntimeException("User not found");

        }
    }
}
