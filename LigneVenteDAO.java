/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetgl;
import com.mycompany.projetgl.LigneVente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import java.sql.ResultSet;

public class LigneVenteDAO {

    private Connection connection;

    public LigneVenteDAO(Connection connection) {
        this.connection = connection;
    }

    public void ajouterLigne(LigneVente ligne) throws SQLException {
       
        String sql = "INSERT INTO lignevente (id_vente, id_produit, quantite, prix_unitaire_fixe, sous_total) VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            
            ps.setInt(1, ligne.getVenteId());
            ps.setInt(2, ligne.getProduitId());
            ps.setInt(3, ligne.getQuantite());
            ps.setDouble(4, ligne.getPrixUnitaire());
            
           
            double sousTotal = ligne.getQuantite() * ligne.getPrixUnitaire();
            ps.setDouble(5, sousTotal);
            
            ps.executeUpdate();
        }
    }

  
    public List<LigneVente> getLignesParVente(int venteId) {
        List<LigneVente> liste = new ArrayList<>();
        String sql = "SELECT * FROM lignevente WHERE id_vente = ?"; 

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, venteId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                LigneVente l = new LigneVente(
                    rs.getInt("id_produit"), 
                    "", 
                    rs.getInt("quantite"),
                    rs.getDouble("prix_unitaire_fixe") 
                );
               
                l.setVenteId(rs.getInt("id_vente"));
                
                liste.add(l);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return liste;
    }
}