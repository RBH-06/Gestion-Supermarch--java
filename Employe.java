/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.projetgl;

public class Employe {
    
   
    private int id;
    private String nom;
    private String prenom;
    private String role;      
    private String username;  
    private String password;  
    private double salaire;

   

   
    public Employe() {
    }

    
    public Employe(String nom, String prenom, String role, String username, String password, double salaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        this.username = username;
        this.password = password;
        this.salaire = salaire;
    }

   
    public Employe(int id, String nom, String prenom, String role, String username, String password, double salaire) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        this.username = username;
        this.password = password;
        this.salaire = salaire;
    }

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    
    @Override
    public String toString() {
        return nom + " " + prenom + " (" + role + ")";
    }
}
