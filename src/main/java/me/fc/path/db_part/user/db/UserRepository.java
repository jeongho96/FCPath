package me.fc.path.db_part.user.db;

import me.fc.path.db_part.db.SimpleDataRepository;
import me.fc.path.db_part.user.model.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class UserRepository extends SimpleDataRepository<UserEntity, Long> {


    public List<UserEntity> findAllScoreGreaterThen(int score){

        return this.findAll().stream()
                .filter(it ->{
                    return it.getScore() >= score;
                }
                ).collect(Collectors.toList());
    }


}
