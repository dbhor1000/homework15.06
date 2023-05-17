import java.util.ArrayList;

public interface EmployeeDAO {

            // Добавление объекта
        void addNewEmployee(Employee employee);
    		// Получение объекта по id
        Employee readEmployeeById(int id);
    		// Получение всех объектов
        ArrayList<Employee> readAllEmployees();
    		// Изменение объекта по id
        void editEmployeeById(int id, String first_name, String last_name, String gender, int age, int city_id);
    		// Удаление объекта по id
        void deleteEmployeeById(int id);
        
}
