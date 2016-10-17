package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author MissAlways
 */
public class DataAccessObject {

    protected Connection getConnection() throws IOException {
        Connection connection = null;
        InputStream inputStream = null;
        Properties properties = new Properties();
        String user = "";
        String password = "";
        String url = "";
        String driver = "";

        try {
            inputStream = new FileInputStream("config.properties");
            properties.load(inputStream);
            user = properties.getProperty("username");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        try {

            Class.forName(driver).newInstance();

            try {
                connection = DriverManager.getConnection(url, user, password);

            } catch (SQLException e) {
                System.out.println("Connection not working.");
                System.out.println("SQLException: " + e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("VendorError: " + e.getErrorCode());
            }
            return connection;
        } catch (Exception e) {
            return null;

        }
    }

    protected static void close(Statement statement, Connection connection) {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            System.out.println("Statement or connection null.");
        }

    }
}