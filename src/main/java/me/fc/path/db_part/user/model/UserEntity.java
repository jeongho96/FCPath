package me.fc.path.db_part.user.model;

import lombok.*;
import me.fc.path.db_part.entity.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity extends Entity {

    private String name;

    private int score;
}
