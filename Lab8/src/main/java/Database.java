import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String DB_DRIVER =
            "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL =
            "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String DB_USERNAME = "STUDENT";
    private static final String DB_PASSWORD = "STUDENT";
    private static Connection connection = null;

    public Database() {
    }

    public static Connection getConnection() {
        if (connection == null){
            createConnection();
        }
        return connection;
    }

    private static void createConnection() {
        try {
            //Register the JDBC driver
            Class.forName(DB_DRIVER);

            //Open the connection
            connection = DriverManager.
                    getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            if (connection != null) {
                System.out.println("Successfully connected");
            } else {
                System.out.println("Failed to connect.");
            }
          //  connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection() {
       // TODO
    }

}