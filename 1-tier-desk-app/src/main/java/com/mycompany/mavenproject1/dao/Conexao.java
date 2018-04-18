package com.mycompany.mavenproject1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private Conexao() {}
    private static Connection connection;
    private static String dbURL = "jdbc:mysql://localhost:3306/saapp";
    private static String username = "root";
    private static String password = "";
    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(dbURL, username, password);
        }
        return connection;
    }
}
