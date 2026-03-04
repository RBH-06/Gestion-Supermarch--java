/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetgl;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class VenteDAO {
    private Connection connection;

    public VenteDAO(Connection connection) {
        this.connection = connection;
    }

   
    public int creerVente(Vente vente) {
        int idGenere = -1;
        try {
            
            String sql = "INSERT INTO vente (total, id_employe) VALUES (?, ?)";
            
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, vente.getMontantTotal());
            ps.setInt(2, vente.getEmployeId());
            
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    idGenere = rs.getInt(1); 
                }
            }
            ps.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idGenere;
    }

    
    public double getChiffreAffairesTotal() {
        try {
           
            ResultSet rs = connection.createStatement().executeQuery("SELECT SUM(total) FROM vente");
            if(rs.next()) return rs.getDouble(1);
        } catch(Exception e) { e.printStackTrace(); }
        return 0.0;
    }

    
    public int getNombreVentesTotal() {
        try {
            ResultSet rs = connection.createStatement().executeQuery("SELECT COUNT(*) FROM vente");
            if(rs.next()) return rs.getInt(1);
        } catch(Exception e) { e.printStackTrace(); }
        return 0;
    }

   
    public List<Vente> getDernieresVentes() {
        List<Vente> list = new ArrayList<>();
        try {
           
            String sql = "SELECT * FROM vente ORDER BY date_vente DESC LIMIT 10";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            
            while(rs.next()) {
                
                Vente v = new Vente(
                    rs.getDouble("total"),     
                    rs.getInt("id_employe")     
                );
                v.setId(rs.getInt("id_vente")); 
                v.setDateVente(rs.getTimestamp("date_vente")); 
                
                list.add(v);
            }
        } catch(Exception e) { 
            System.out.println("Erreur chargement historique : " + e.getMessage());
            e.printStackTrace(); 
        }
        return list;
    }
}
