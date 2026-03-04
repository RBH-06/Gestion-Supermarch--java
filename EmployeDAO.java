/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetgl;


import com.mycompany.projetgl.Employe;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmployeDAO {

    private Connection conn;

    public EmployeDAO(Connection conn) {
        this.conn = conn;
    }

   
    public void ajouter(Employe e) {
        
        String sql = "INSERT INTO employe (nom, prenom, role, username, password, salaire) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, e.getNom());
            ps.setString(2, e.getPrenom());
            ps.setString(3, e.getRole());
            ps.setString(4, e.getUsername());
            ps.setString(5, e.getPassword());
            ps.setDouble(6, e.getSalaire());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erreur SQL : " + ex.getMessage());
            ex.printStackTrace();
        }
    }

   public void modifier(Employe e) {
        String sql;
        boolean updatePassword = e.getPassword() != null && !e.getPassword().isEmpty();

        if (updatePassword) {
            sql = "UPDATE employe SET nom=?, prenom=?, role=?, username=?, salaire=?, password=? WHERE id_employe=?";
        } else {
            sql = "UPDATE employe SET nom=?, prenom=?, role=?, username=?, salaire=? WHERE id_employe=?";
        }

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, e.getNom());
            ps.setString(2, e.getPrenom());
            ps.setString(3, e.getRole());
            ps.setString(4, e.getUsername());
            ps.setDouble(5, e.getSalaire());

            if (updatePassword) {
                ps.setString(6, e.getPassword());
                ps.setInt(7, e.getId()); 
            } else {
                ps.setInt(6, e.getId());
            }

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erreur Modifier : " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    
    public void supprimer(int id) {
        String sql = "DELETE FROM employe WHERE id_employe=?"; 
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erreur Supprimer : " + ex.getMessage());
            ex.printStackTrace();
        }
    }

   public List<Employe> lister() {
        List<Employe> list = new ArrayList<>();
        String sql = "SELECT * FROM employe"; 
        
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            
            while (rs.next()) {
                Employe e = new Employe(
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("role"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getDouble("salaire")
                );
                
              
                try {
                    e.setId(rs.getInt("id_employe")); 
                } catch (SQLException s) {
                   
                    e.setId(rs.getInt("id"));
                }
             
                
                list.add(e);
            }
        } catch (SQLException ex) {
            System.err.println("ERREUR CRITIQUE DANS LISTER() : " + ex.getMessage());
            ex.printStackTrace();
        }
        return list;
    }

   
    public Employe getByUsername(String username) {
        Employe e = null;
        String sql = "SELECT * FROM employe WHERE username = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    e = new Employe(
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("role"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getDouble("salaire")
                    );
                   e.setId(rs.getInt("id_employe"));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return e;
    }
}
