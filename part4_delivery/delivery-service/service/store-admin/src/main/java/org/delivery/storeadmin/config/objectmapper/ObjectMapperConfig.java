package org.delivery.storeadmin.config.objectmapper;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// ObjectMapper는 기본적으로 Object를 JSON으로 전달 시 CamelCase를 기반으로 전달함.
// response마다 @JsonNaming을 통해서 다 스네이크 케이스로 변경하면 중복이 발생.
// custom한 ObjectMapper를 만들어서 전달하면 좋음.
@Configuration
public class ObjectMapperConfig {

    @Bean
    public ObjectMapper objectMapper() {
        var objectMapper = new ObjectMapper();

        // JDK8 버전 이후 클래스 처리
        objectMapper.registerModule(new Jdk8Module());
        // LocalDateTime 같은 표준 처리
        objectMapper.registerModule(new JavaTimeModule());
        // 모르는 json value에 대해서 무시하고 parsing
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        // 날짜 관련 직렬화
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        // 스네이크 케이스
        objectMapper.setPropertyNamingStrategy(new PropertyNamingStrategies.SnakeCaseStrategy());

        return objectMapper;
    }
}
