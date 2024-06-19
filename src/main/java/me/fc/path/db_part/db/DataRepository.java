package me.fc.path.db_part.db;

import java.util.List;
import java.util.Optional;

public interface DataRepository<T, ID> extends Repository<T, ID> {


    // create , update
    // 있으면 update, 없으면 create
    T save(T data);

    // read
    Optional<T> findById(ID id);

    List<T> findAll();

    // delete
    void delete(ID id);
}
