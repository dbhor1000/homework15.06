import java.sql.*;
public class Application {

    public static void main(String[] args) throws SQLException {

        // Создаем переменные с данными для подключения к базе
        final String user = "postgres";
        final String password = "123456";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        // Создаем соединение с базой с помощью Connection
        // Формируем запрос к базе с помощью PreparedStatement
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee FULL JOIN city ON employee.city_id = city.city_id WHERE id=(?)")) {


            // Подставляем значение вместо wildcard
            statement.setInt(1, 2);

            // Делаем запрос к базе и результат кладем в ResultSet
            final ResultSet resultSet = statement.executeQuery();

            // Методом next проверяем есть ли следующий элемент в resultSet
            // и одновременно переходим к нему, если таковой есть
            while (resultSet.next()) {

                // С помощью методов getInt и getString получаем данные из resultSet
                String firstName = "Title: " + resultSet.getString("first_name");
                String lastName = "Title: " + resultSet.getString("last_name");
                String gender = "Author_id: " + resultSet.getString("gender");
                String city = "Author_id: " + resultSet.getString("city_name");


                // Выводим данные в консоль
                System.out.println(firstName);
                System.out.println(lastName);
                System.out.println(gender);
                System.out.println(city);

            }
        }

        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        Employee employee1 = new Employee(7, "Ivan", "Ivanov", "Male", 37, 3);
        employeeDAO.addNewEmployee(employee1);
        employeeDAO.readEmployeeById(4);
        employeeDAO.readAllEmployees();
        employeeDAO.editEmployeeById(5, "Safron", "Safronov", "Male", 30, 2);
        employeeDAO.deleteEmployeeById(3);

    }



}
