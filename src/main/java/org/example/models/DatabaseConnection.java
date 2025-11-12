package org.example.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:postgresql://postgresql-groupeffa.alwaysdata.net:5432/groupeffa_voucher";
    private static final String USER = "groupeffa";
    private static final String PASSWORD = "1234@Ad$ffA";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Connexion réussie à la base de données !");
        } catch (SQLException e) {
            System.out.println("❌ Erreur de connexion à la base de données : " + e.getMessage());
        }
        return connection;
    }
}
