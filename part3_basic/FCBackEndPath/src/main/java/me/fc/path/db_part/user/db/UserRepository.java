package me.fc.path.db_part.user.db;

import me.fc.path.db_part.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {


    // select * from user where score > {??} 이상이면 ThanEqual
    public List<UserEntity> findAllByScoreGreaterThanEqual(int score);

    // select * from user where score >= ?? AND score <= ??
    public List<UserEntity> findAllByScoreGreaterThanEqualAndScoreLessThanEqual(int min, int max);


    // ?1 = min / ?2 = max 매개변수 순서대로 입력받기
    // 별칭으로 입력받기도 가능. Param으로 입력 후 :별칭 형태로 입력
    @Query(
            "select u from user u where u.score >= :min AND u.score <= :max"
    )
    List<UserEntity> score(
            @Param(value = "min") int min,
            @Param(value = "max") int max);
}
