package genericInterface;

import model.Book;
import model.Topic;

import java.sql.SQLException;
import java.util.List;

public interface crudOperations<T> {
    List<T> findAll() throws SQLException;
    List<T> saveAll(List<T>toSave) throws SQLException;

    T save(T toSave) throws SQLException;

    void delete(int id_book) throws SQLException;
}
