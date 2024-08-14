package org.delivery.storeadmin.config.security;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private List<String> SWAGGER = List.of(
            "/swagger-ui.html",
            "/swagger-ui/**",
            "v3/api-docs/**"

    );

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .authorizeHttpRequests(it ->{
                    it
                            .requestMatchers(
                                    PathRequest.toStaticResources().atCommonLocations()
                            ).permitAll() // resource에 대해서는 모든 요청을 허용함.

                            // swagger는 인증 없이 통과
                            .requestMatchers(
                                    SWAGGER.toArray(new String[0])
                            ).permitAll()
                            // open-api / ** 의 하위 모든 주소는 인증 없이 통과
                            .requestMatchers(
                                    "/open-api/**"
                            ).permitAll()
                            // 그외 모든 요청은 인증 사용
                            .anyRequest().authenticated();
                })
                .formLogin(Customizer.withDefaults());

        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        // hash로 암호화
        // 단방향 암호화로 암호해독은 불가능하며, 입력한 값을 암호화 했을 때 값만 비교
        return new BCryptPasswordEncoder();
    }
}
