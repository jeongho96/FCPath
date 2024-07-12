package com.fc.board.model;



import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fc.post.model.PostDto;
import lombok.*;


import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BoardDto {

    private Long id;

    private String boardName;

    private String status;

    private List<PostDto> postList = List.of();
}