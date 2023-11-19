package crudOps;

import genericInterface.crudOperations;
import model.Author;
import model.Book;
import model.Topic;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorCrud implements crudOperations<Author> {
    private Connection connection;
    public AuthorCrud(Connection connection) {
        this.connection = connection;
    }
    @Override
    public List<Author> findAll() throws SQLException {
        List<Author> allAuthors = new ArrayList<>();
        String sql = "SELECT * FROM author";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet result = preparedStatement.executeQuery();
            while(result.next()){
                convertToList(allAuthors, result);
            }
        }
        System.out.println(allAuthors);
        return allAuthors;
    }

    @Override
    public Author save(Author toSave) throws SQLException {
        String query = "INSERT INTO author (id_author, name, gender) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, toSave.getId_author());
            preparedStatement.setString(2, toSave.getName());
            preparedStatement.setString(3, toSave.getGender());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toSave;
    }

    @Override
    public List<Author> saveAll(List<Author> toSave) throws SQLException {
        String query = "INSERT INTO Author (id_author, name, gender) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            for (Author author : toSave) {
                preparedStatement.setInt(1, author.getId_author());
                preparedStatement.setString(2, author.getName());
                preparedStatement.setString(3, author.getGender());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        }
        return toSave;
    }


    @Override
    public Author delete(Author toDelete) throws SQLException {
        String sql = "DELETE FROM author WHERE id_author = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, toDelete.getId_author());
            preparedStatement.executeUpdate();
        }
        System.out.println("DELETE 01");
        return toDelete;
    }
    private void convertToList(List<Author> allAuthors, ResultSet result) throws SQLException {
        allAuthors.add(new Author(
                result.getInt("id_author"),
                result.getString("name"),
                result.getString("gender")
        ));
    }
}
