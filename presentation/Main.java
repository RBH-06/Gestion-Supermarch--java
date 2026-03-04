/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetgl.presentation;



import com.mycompany.projetgl.DAO.DBConnection;
import com.mycompany.projetgl.presentation.Login;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Main {

    public static void main(String[] args) {
        
        System.out.println("--- Démarrage de l'application Superette ---");

        
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Erreur de chargement du design : " + e.getMessage());
        }

       
        Connection con = DBConnection.getConnection();
        if (con == null) {
            JOptionPane.showMessageDialog(null, "Impossible de se connecter à la base de données !\nVérifiez WAMP/XAMPP.", "Erreur Fatale", JOptionPane.ERROR_MESSAGE);
           
           
        } else {
            System.out.println("Connexion BDD initiale : SUCCÈS");
        }

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
}
