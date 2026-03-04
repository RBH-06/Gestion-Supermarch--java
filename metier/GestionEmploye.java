/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetgl.metier;


import com.mycompany.projetgl.EmployeDAO;
import com.mycompany.projetgl.Employe;
import java.sql.Connection;

import java.util.List;

public class GestionEmploye {

    private EmployeDAO employeDAO;

    public GestionEmploye(Connection conn) {
        this.employeDAO = new EmployeDAO(conn);
    }

   
    public Employe authentifier(String username, String password) throws Exception {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new Exception("Veuillez remplir tous les champs.");
        }

       
        Employe employe = employeDAO.getByUsername(username);

        if (employe == null) {
            throw new Exception("Nom d'utilisateur inconnu.");
        }

       
        if (employe.getPassword().equals(password)) {
            return employe; 
        } else {
            throw new Exception("Mot de passe incorrect.");
        }
    }

    
    public void ajouterEmploye(String nom, String prenom, String role, double salaire, String username, String password) throws Exception {
       
        if (nom == null || nom.trim().isEmpty() || prenom == null || prenom.trim().isEmpty()) {
            throw new Exception("Le nom et le prénom sont obligatoires.");
        }
        if (salaire < 0) {
            throw new Exception("Le salaire ne peut pas être négatif.");
        }
        if (username == null || username.length() < 3) {
            throw new Exception("Le nom d'utilisateur doit faire au moins 3 caractères.");
        }
        
        
        if (employeDAO.getByUsername(username) != null) {
            throw new Exception("Ce nom d'utilisateur est déjà pris !");
        }

       
        Employe nouvelEmploye = new Employe(nom, prenom, role, username, password, salaire);
        
       
        employeDAO.ajouter(nouvelEmploye);
    }

   
    public List<Employe> listerTousLesEmployes() {
        return employeDAO.lister();
    }

  
    public void modifierEmploye(int id, String nom, String prenom, String role, double salaire, String username, String password) throws Exception {
        // A. Validation
        if (id <= 0) throw new Exception("ID invalide.");
        if (salaire < 0) throw new Exception("Le salaire ne peut pas être négatif.");
        if (nom.isEmpty() || prenom.isEmpty()) throw new Exception("Nom et Prénom requis.");

        
        Employe employeModifie = new Employe(nom, prenom, role, username, password, salaire);
        employeModifie.setId(id); 
        
       
        employeDAO.modifier(employeModifie);
    }

  
    public void supprimerEmploye(int id) throws Exception {
        if (id <= 0) {
            throw new Exception("Impossible de supprimer : ID invalide.");
        }
        
        
        
        employeDAO.supprimer(id);
    }
}
