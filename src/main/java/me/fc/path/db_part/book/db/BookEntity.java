package me.fc.path.db_part.book.db;

import lombok.*;
import me.fc.path.db_part.entity.Entity;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookEntity extends Entity {

    private String name;
    private String category;
    private BigDecimal amount;
}