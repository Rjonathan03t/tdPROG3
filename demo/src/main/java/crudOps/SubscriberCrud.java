package crudOps;

import genericInterface.crudOperations;
import model.Author;
import model.Book;
import model.Subscriber;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubscriberCrud implements crudOperations<Subscriber> {
    private Connection connection;
    public SubscriberCrud(Connection connection) {
        this.connection = connection;
    }
    @Override
    public List<Subscriber> findAll() throws SQLException {
        List<Subscriber> allSubs = new ArrayList<>();
        String sql = "SELECT * FROM subscriber";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet result = preparedStatement.executeQuery();
            while(result.next()){
                convertToList(allSubs, result);
            }
        }
        System.out.println(allSubs);
        return allSubs;
    }

    @Override
    public List<Subscriber> saveAll(List<Subscriber> toSave) throws SQLException {
        String query = "INSERT INTO subscriber (id_user, name, password) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            for (Subscriber subscriber : toSave) {
                preparedStatement.setInt(1, subscriber.getId_user());
                preparedStatement.setString(2, subscriber.getName());
                preparedStatement.setString(3, subscriber.getPassword());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toSave;
    }

    @Override
    public Subscriber save(Subscriber toSave) throws SQLException {
        String query = "INSERT INTO subscriber (id_user, name, password) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, toSave.getId_user());
            preparedStatement.setString(2, toSave.getName());
            preparedStatement.setString(3, toSave.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toSave;
    }

    @Override
    public Subscriber delete(Subscriber toDelete) throws SQLException {
        String sql = "DELETE FROM subscriber WHERE id_user = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, toDelete.getId_user());
            preparedStatement.executeUpdate();
        }
        System.out.println("DELETE 01");
        return toDelete;
    }
    private void convertToList(List<Subscriber> allSubs, ResultSet result) throws SQLException {
        allSubs.add(new Subscriber(
                result.getInt("id_user"),
                result.getString("name"),
                result.getString("password")
        ));
    }
}
