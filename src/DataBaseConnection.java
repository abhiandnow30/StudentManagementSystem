import java.sql.*;

    public class DataBaseConnection {
        private static final String URL = "jdbc:mysql://localhost:3306/abhilasha";
        private static final String USER = "root"; // your MySQL username
        private static final String PASSWORD = "123456"; // your MySQL password

        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }
    }


