package dataAccess;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import connection.ConnectionFactory;
import model.Client;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AbstractDataAccess<T>{

    protected static final Logger LOGGER = Logger.getLogger(AbstractDataAccess.class.getName());
    private final Class<T> type;

    public AbstractDataAccess(){
        this.type = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public static List<Field> getAllFields(List<Field> fields, Class<?> type) {
        fields.addAll(Arrays.asList(type.getDeclaredFields()));

        if (type.getSuperclass() != null) {
            getAllFields(fields, type.getSuperclass());
        }

        return fields;
    }

    List<T> createObjects(ResultSet result) {
        List<T> list = new ArrayList<T>();
        Field broken = null;
        try {
            while (result.next()) {
                T instance = type.newInstance();
                for (Field field : getAllFields(new LinkedList<Field>(), type)) {
                    field.setAccessible(true);
                    Object value = result.getObject(field.getName());
                    broken = field;
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println(broken.toString());
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

    private final String selectAllQuery(){
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT * FROM " + type.getSimpleName() + ";");
        return builder.toString();
    }

    public List<T> selectAll(){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        String query = selectAllQuery();
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            result = statement.executeQuery();
            return createObjects(result);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getSimpleName() + "DAO: SELECT ALL" + e.getMessage());
        } finally {
            ConnectionFactory.close(result);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    private final String viewClientQuery(String field){
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT * FROM ");
        builder.append(type.getSimpleName());
        builder.append(" WHERE " + field + "=?");
        return builder.toString();
    }

    public List<T> searchAfter(String field, String after){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        String query = viewClientQuery(field);
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, after);
            result = statement.executeQuery();
            List<T> list = createObjects(result);
            if (list.isEmpty())
                return null;
            else {
                return list;
            }
        } catch (SQLException e) {
           // e.printStackTrace();
        }finally {
            ConnectionFactory.close(result);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    public List<T> searchAfterId(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        String query = viewClientQuery("id");
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            result = statement.executeQuery();
            List<T> list = createObjects(result);
            if (list.isEmpty())
                return null;
            else {
                return list;
            }
        } catch (SQLException e) {
            // e.printStackTrace();
        }finally {
            ConnectionFactory.close(result);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    private final String deleteAfterQuery(String field){
        StringBuilder builder = new StringBuilder();
        builder.append("DELETE FROM " + type.getSimpleName() + " WHERE " + field + "=?");
        return builder.toString();
    }

    public void deleteAfter(String field, String personalNumericalCode){
        Connection connection = null;
        PreparedStatement statement = null;
        String query = deleteAfterQuery(field);
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, personalNumericalCode);
            statement.executeUpdate();
        } catch (SQLException e) {
            //e.printStackTrace();
        }finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }
/*
    private final String searchAfterUsernameQuery(String username){
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT * FROM " + type.getSimpleName() + " WHERE username=?");
        return builder.toString();
    }

    public T searchAfterUsername(String username){
            Connection connection = null;
            PreparedStatement statement = null;
            ResultSet result = null;
            String query = viewClientQuery("username");
            try{
                connection = ConnectionFactory.getConnection();
                statement = connection.prepareStatement(query);
                statement.setString(1, username);
                result = statement.executeQuery();
                List<T> list = createObjects(result);
                if (list.isEmpty())
                    return null;
                else {
                    return list.get(0);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                ConnectionFactory.close(result);
                ConnectionFactory.close(statement);
                ConnectionFactory.close(connection);
            }
            return null;
    }

 */
}
