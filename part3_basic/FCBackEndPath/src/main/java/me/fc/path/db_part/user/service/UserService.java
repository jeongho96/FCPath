package me.fc.path.db_part.user.service;


import lombok.RequiredArgsConstructor;
import me.fc.path.db_part.user.db.UserRepository;
import me.fc.path.db_part.user.model.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserEntity save(UserEntity user){
        // save
        return userRepository.save(user);
    }

    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    public void delete(UserEntity id){
        userRepository.delete(id);
    }

    public Optional<UserEntity> findById(Long id){
        return userRepository.findById(id);
    }

    public List<UserEntity> filterScore(int score){

        return userRepository.findAllByScoreGreaterThanEqual(score);
    }

    public List<UserEntity> filterScore(int min, int max){

        return userRepository.findAllByScoreGreaterThanEqualAndScoreLessThanEqual(min, max);
    }
}
