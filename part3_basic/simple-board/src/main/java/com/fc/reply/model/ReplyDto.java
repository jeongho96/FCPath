package com.fc.reply.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fc.post.db.PostEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ReplyDto {


    private Long id;

    private Long postId;    // post => _id => post_id

    private String userName;

    private String password;

    private String status;

    private String title;

    private String content;

    private LocalDateTime repliedAt;

}