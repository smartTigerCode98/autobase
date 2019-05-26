package db_manager;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class DBManager {

    private static DBManager instance = null;

    private static final String URL = "jdbc:mysql://localhost:3306/autobase";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private Connection connection;

    public static DBManager getInstance() throws Exception {
        if(instance == null){
            instance = new DBManager();
        }
        return instance;
    }

    private DBManager() throws Exception{
        Driver driver = new FabricMySQLDriver();
        DriverManager.registerDriver(driver);
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        if (connection.isClosed()) {
            throw new RuntimeException("Connection failed");
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
