package me.fc.path.db_part.book.db;



import me.fc.path.db_part.db.SimpleDataRepository;
import org.springframework.stereotype.Service;

@Service
public class BookRepository extends SimpleDataRepository<BookEntity, Long> {
}