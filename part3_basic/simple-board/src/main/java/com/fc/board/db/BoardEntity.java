package com.fc.board.db;


import com.fc.post.db.PostEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity(name = "board")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String boardName;

    private String status;

    @OneToMany(
            mappedBy = "boardEntity"
    )
    @Builder.Default
    @Where(clause = "status = 'REGISTERED'")
//    @org.hibernate.annotations.OrderBy(clause = "id desc")
    @OrderBy(value = "id desc")
    private List<PostEntity> postList = List.of();
}
