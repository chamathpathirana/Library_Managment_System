package Controllers.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {

    private static Connection connection;
    private static dbConnection intance;

    public static Connection getConnection(){

        {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/LibraryManagementSystem",
                        "root",
                        "12345");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

    public static dbConnection getInstance() {
        if (intance == null){
            intance = new dbConnection();
        }
        return intance;
    }

}
