package crudOps;

import genericInterface.crudOperations;
import model.Book;
import model.Topic;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookCrud  implements crudOperations<Book> {
    private  Connection connection;
    public BookCrud(Connection connection) {
        // Initialisez la connexion dans le constructeur
        this.connection = connection;
    }


    @Override
    public List<Book> findAll() throws SQLException {
        List<Book> allBooks = new ArrayList<>();
        String sql = "SELECT * FROM book";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet result = preparedStatement.executeQuery();
            while(result.next()){
                convertToList(allBooks, result);
            }
        }
        System.out.println(allBooks);
        return allBooks;
    }

    @Override
    public List<Book> saveAll(List<Book> toSave) throws SQLException {
        String query = "INSERT INTO Book (id_book, title, topic, id_author) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            for (Book book : toSave) {
                preparedStatement.setInt(1, book.getId_book());
                preparedStatement.setString(2, book.getTitle());
                preparedStatement.setObject(3, book.getTopic().getTopic_name(), Types.OTHER); // Assuming Topic has a 'topic_name' property
                preparedStatement.setInt(4, book.getId_author());
                preparedStatement.addBatch(); // Add this book to the batch
            }
            preparedStatement.executeBatch(); // Execute the batch
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toSave;
    }

    @Override
    public Book save(Book toSave) throws SQLException {
        String query = "INSERT INTO Book (id_book, title, topic, id_author) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, toSave.getId_book());
            preparedStatement.setString(2, toSave.getTitle());
            preparedStatement.setObject(3, toSave.getTopic().getTopic_name(), Types.OTHER); // Utiliser l'ID du topic
            preparedStatement.setInt(4, toSave.getId_author());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toSave;
    }


    @Override
    public void delete(int id_book) throws SQLException {
        String sql = "DELETE FROM book WHERE id_book = "+id_book;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.executeUpdate();
        }
        System.out.println("DELETE 01");
    }
    private void convertToList(List<Book> allBooks, ResultSet result) throws SQLException {
        allBooks.add(new Book(
                result.getInt("id_book"),
                result.getString("title"),
                new Topic(result.getString("topic")),
                result.getInt("id_author")
        ));
    }
}
