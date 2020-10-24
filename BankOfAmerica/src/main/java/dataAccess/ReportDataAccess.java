package dataAccess;

import connection.ConnectionFactory;
import model.Account;
import model.Employee;
import model.Report;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReportDataAccess extends AbstractDataAccess<Report> {
    private final String addQuery(Report report){
        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO Report VALUES(?, ?, ?, ?, ?)");
        return builder.toString();
    }

    public void addReport(Report report) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = addQuery(report);
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, report.getId());
            statement.setString(2, report.getFirstName());
            statement.setString(3, report.getLastName());
            statement.setString(4, report.getOperation());
            statement.setString(5, report.getDateOfCreation());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }
    private final String updateReportQuery(){
            StringBuilder builder = new StringBuilder();
            builder.append("UPDATE Report set " +
                    " firstName=?, lastName=?  where id=? ");
            return builder.toString();
    }
    public void updateReport(Report report){
        Connection connection = null;
        PreparedStatement statement = null;
        String query = updateReportQuery();
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, report.getFirstName());
            statement.setString(2, report.getLastName());
            statement.setInt(3, report.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            //e.printStackTrace();
        }finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }
}
