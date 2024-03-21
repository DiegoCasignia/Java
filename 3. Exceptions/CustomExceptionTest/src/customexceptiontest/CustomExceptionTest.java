package customexceptiontest;

import java.util.ArrayList;

/**
 *
 * @author Diego Casignia
 */

public class CustomExceptionTest {
    public static void main(String[] args) throws EmployeeNotFoundException {
        ArrayList<Employee> employeeArr =new ArrayList();
        Employee employee1 = new Employee(0,"Dario");
        Employee employee2 = new Employee(1,"Juan");
        Employee employee3 = new Employee(2,"Pedro");
        employeeArr.add(employee1);
        employeeArr.add(employee2);
        employeeArr.add(employee3);
        String search ="Pepe";
        boolean employeeFound = false;
        for (Employee employee : employeeArr) {
            if (employee.getName().equals(search)) {
                employeeFound = true;
                employeeArr.remove(employee);
                break;
            }
        }
        if (!employeeFound) {
            throw new EmployeeNotFoundException("Employee not found: " + search);
        }
        for (Employee employee : employeeArr) {
            System.out.println(employee.toString());
        }
    }
}
