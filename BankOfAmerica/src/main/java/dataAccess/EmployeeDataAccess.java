package dataAccess;

import connection.ConnectionFactory;
import model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDataAccess extends AbstractDataAccess<Employee> {
    private final String addEmployeeQuery(Employee employee){
        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO Employee(id, firstName, lastName, personalNumericalCode, username, password) VALUES (?, ?, ?, ?, ?, ?);");
        return builder.toString();
    }

    public void addEmployee(Employee employee){
        Connection connection = null;
        PreparedStatement statement = null;
        String query = addEmployeeQuery(employee);
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, employee.getId());
            statement.setString(2, employee.getFirstName());
            statement.setString(3, employee.getLastName());
            statement.setString(4, employee.getPersonalNumericalCode());
            statement.setString(5, employee.getUsername());
            statement.setString(6, employee.getPassword());
            statement.executeUpdate();
        }catch (SQLException e){
            //e.printStackTrace();
        }finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

    private final String updateEmployeeQuery(Employee employee){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE Employee set firstName=?, lastName=?, personalNumericalCode=?, username=?, password=? where id=?");
        return stringBuilder.toString();
    }

    public void updateEmployee(Employee employee){
        Connection connection = null;
        PreparedStatement statement = null;
        String query = updateEmployeeQuery(employee);
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getPersonalNumericalCode());
            statement.setString(4, employee.getUsername());
            statement.setString(5, employee.getPassword());
            statement.setInt(6,employee.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            //e.printStackTrace();
        }finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

    private final String viewEmployeeQuery(String firstName, String lastName){
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT * FROM Employee WHERE " + firstName + "=? and " + lastName + "=?");
        return builder.toString();
    }

   public List<Employee> searchAfterName(String field1, String field2,String firstName, String lastName){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        String query = viewEmployeeQuery(field1, field2);
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, firstName);
            statement.setString(2,lastName);
            result = statement.executeQuery();
            List<Employee> list = createObjects(result);
            if (list.isEmpty())
                return null;
            else {
                return list;
            }
        } catch (SQLException e) {
            //e.printStackTrace();
        }finally {
            ConnectionFactory.close(result);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

}
