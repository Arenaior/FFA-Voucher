package org.example.models;

public class User {
    private String username;
    private String nom;
    private String prenom;
    private String email;
    private String userRole;

    public User(String username, String nom, String prenom, String email, String userRole) {
        this.username = username;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.userRole = userRole;
    }

    // --- Getters & Setters ---
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return prenom + " " + nom + " (" + userRole + ")";
    }
}
