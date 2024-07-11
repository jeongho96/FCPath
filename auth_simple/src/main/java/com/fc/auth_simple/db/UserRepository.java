package com.fc.auth_simple.db;

import com.fc.auth_simple.model.UserDto;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserRepository {

    private List<UserDto> userList = new ArrayList<>();

    public Optional<UserDto> findByName(String name) {
        return userList.stream().filter(it -> {
            return it.getName().equals(name);
        }).findFirst();
    }

    // 빈 초기화 시 생성
    @PostConstruct
    public void init(){
        userList.add(
                new UserDto(
                        "철수", "1234"
                )
        );

        userList.add(
                new UserDto(
                        "유관순", "1234"
                )
        );

        userList.add(
                new UserDto(
                        "홍길동", "1234"
                )
        );
    }
}
