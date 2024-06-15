package me.fc.fcbackendpath.restapi.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class BookRequest {

    // ObjectMapper로 자동 직렬화 / 역직렬화 시 반영하지 않음을 표시
    @JsonIgnore
    private String title;

    private String name;

    private String phoneNumber;

    private String email;

    @Override
    public String toString() {
        return "BookRequest{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
