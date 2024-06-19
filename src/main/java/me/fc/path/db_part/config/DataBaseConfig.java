package me.fc.path.db_part.config;


import me.fc.path.db_part.user.db.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataBaseConfig {

    @Bean
    public UserRepository userRepository() {
        return new UserRepository();
    }
}
