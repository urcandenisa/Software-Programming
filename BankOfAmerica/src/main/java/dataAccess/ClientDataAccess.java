package dataAccess;

import connection.ConnectionFactory;
import model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ClientDataAccess extends AbstractDataAccess<Client> {

    private final String addClientQuery(Client client){
        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO Client(id, firstName, lastName, identityCardNumber, personalNumericalCode, address) VALUES(?, ?, ?, ?, ?, ?) ");
        return builder.toString();
    }

    public void addClient(Client client){
        Connection connection = null;
        PreparedStatement statement = null;
        String query = addClientQuery(client);
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, client.getId());
            statement.setString(2, client.getFirstName());
            statement.setString(3, client.getLastName());
            statement.setString(4, client.getIdentityCardNumber());
            statement.setString(5, client.getPersonalNumericalCode());
            statement.setString(6, client.getAddress());
            statement.executeUpdate();
        }catch (SQLException e){

        }finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

    private final String updateClientQuery(Client client){
        StringBuilder builder = new StringBuilder();
        builder.append("UPDATE Client SET firstName=?, lastName=?, identityCardNumber=?, personalNumericalCode=?, address=? where id=? ");
        return builder.toString();
    }

    public void updateClient(Client client){
        Connection connection = null;
        PreparedStatement statement = null;
        String query = updateClientQuery(client);
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, client.getFirstName());
            statement.setString(2, client.getLastName());
            statement.setString(3, client.getIdentityCardNumber());
            statement.setString(4, client.getPersonalNumericalCode());
            statement.setString(5, client.getAddress());
            statement.setInt(6, client.getId());

            statement.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }
}
