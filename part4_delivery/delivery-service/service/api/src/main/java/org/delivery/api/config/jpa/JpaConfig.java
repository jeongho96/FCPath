package org.delivery.api.config.jpa;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// 스프링의 경우 자신의 패키지 안에 있는 친구들을 빈으로 만들어준다.
// 멀티모듈시에는 패키지가 달라 빈 등록이 안될수 있기 떄문에 이런문제를 고려해야함.
@Configuration
@EntityScan(basePackages = "org.delivery.db")
@EnableJpaRepositories(basePackages = "org.delivery.db")
public class JpaConfig {
}
