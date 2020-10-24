package dataAccess;

import connection.ConnectionFactory;
import model.Account;

import java.math.BigDecimal;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class AccountDataAccess extends AbstractDataAccess<Account> {

    private final String addAccountQuery(Account account){
        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO Account VALUES (?, ?, ?, ?, ?)");
        return builder.toString();
    }

    public void addAccount(Account account){
        Connection connection = null;
        PreparedStatement statement = null;
        String query = addAccountQuery(account);
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, account.getPersonalNumericalCode());
            statement.setString(2, account.getIdentificationNumber());
            statement.setString(3, account.getType());
            statement.setDouble(4, account.getAmountOfMoney());
            statement.setString(5, account.getDateOfCreation());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

    private final String updateAccountQuery(Account account){
        StringBuilder builder = new StringBuilder();
        builder.append("UPDATE Account set " +
                " type=?, amountOfMoney=?  where identificationNumber=? ");
        return builder.toString();
    }

    public void updateAccount(Account account){
        Connection connection = null;
        PreparedStatement statement = null;
        String query = updateAccountQuery(account);
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(3, account.getIdentificationNumber());
            statement.setString(1, account.getType());
            statement.setDouble(2, account.getAmountOfMoney());

            statement.executeUpdate();

        } catch (SQLException e) {
            //e.printStackTrace();
        }finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }
}
