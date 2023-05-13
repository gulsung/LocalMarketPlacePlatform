package webserver.estuceng.LocalFarmerMarketplacePlatform;

import java.sql.*;

public class DatabaseConnection {
    private Connection connection;

    public DatabaseConnection(String url, String user, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, user, password);
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(sql);
    }

    public int executeUpdate(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeUpdate(sql);
    }

    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
