package database;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;

/**
 * Created by Billy on 6/13/2016.
 */
public class DBConnector {
    public static final String URL = "jdbc:mysql://192.168.56.1:3306/dbtest";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "root";
    private static DBConnector dbConnector;
    private static Connection connection;

    private DBConnector() {
        setConnection();
    }

    public void dbFileWriter(String currentURL){
        try (InputStream inputStream = new BufferedInputStream(new URL(currentURL).openStream());
                PreparedStatement preparedStatement = connection
                        .prepareStatement("INSERT INTO photos (date, photoFile) VALUES(?,?)")) {
            preparedStatement.setBinaryStream(2, inputStream);
            preparedStatement.setDate(1, new Date(System.currentTimeMillis()));
            preparedStatement.execute();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static DBConnector getInstance() {
        if (dbConnector == null) {
            return dbConnector = new DBConnector();
        }
        return dbConnector;
    }

    private void setConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
