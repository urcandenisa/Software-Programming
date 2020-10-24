package businessLogic;

import dataAccess.EmployeeDataAccess;
import model.Employee;
import java.util.List;

public class EmployeeBusiness {
    private EmployeeDataAccess employeeDataAccess;

    public EmployeeBusiness(){
        employeeDataAccess = new EmployeeDataAccess();
    }

    public void addEmployee(Employee employee){
        employeeDataAccess.addEmployee(employee);
    }

    public List<Employee> selectAll(){
        List<Employee> employeesList = employeeDataAccess.selectAll();
        if(employeesList == null){
            return null;
        }
        return employeesList;
    }

    public List<Employee> searchAfterName(String field1, String field2, String firstName, String lastName){
        List<Employee> employeesList = employeeDataAccess.searchAfterName(field1, field2, firstName,lastName);
        if(employeesList == null){
            return null;
        }
        return employeesList;
    }

    public Employee searchAfter(String field, String personalNumericalCode){
        return employeeDataAccess.searchAfter(field, personalNumericalCode).get(0);
    }


    public void deleteAfter(String personalNumericalCode){
        Employee employee = employeeDataAccess.searchAfter("personalNumericalCode",personalNumericalCode).get(0);
        if(employee == null);
        employeeDataAccess.deleteAfter("personalNumericalCode",personalNumericalCode);
    }

    public void updateEmployee(String firstName, String lastName, String personalNumericalCode, String username, String password, int id){
        employeeDataAccess.updateEmployee(new Employee(id, firstName, lastName, personalNumericalCode, username, password));
    }
}
