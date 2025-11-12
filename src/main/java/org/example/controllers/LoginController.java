package org.example.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.models.DatabaseConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {

    @FXML private TextField emailField;
    @FXML private TextField passwordField;
    @FXML private Button loginButton;

    @FXML
    private void handleLogin() {
        String email = emailField.getText();
        String password = passwordField.getText();

        if (email.isEmpty() || password.isEmpty()) {
            System.out.println("Veuillez remplir tous les champs.");
            return;
        }

        // Vérifier en base
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM users WHERE email=? AND userpassword=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("Connexion réussie !");
                // ✅ C'est ici qu'on appelle la méthode pour changer de scène
                gotoDashboard();
            } else {
                System.out.println("Email ou mot de passe incorrect.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void gotoDashboard() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Dashboard.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) loginButton.getScene().getWindow(); // récupère la fenêtre actuelle
            stage.setScene(scene);
            stage.setTitle("Dashboard");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
