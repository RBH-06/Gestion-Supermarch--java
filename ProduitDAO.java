/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetgl;
        


import com.mycompany.projetgl.Produit;
import java.sql.*;
import java.util.*;

public class ProduitDAO {
    private Connection connection;

    public ProduitDAO(Connection connection) {
        this.connection = connection;
    }

    
    private Produit mapResultSetToProduit(ResultSet rs) throws SQLException {
        Produit p = new Produit();
        
      
        p.setId(rs.getInt("id_produit")); 
        
        p.setNom(rs.getString("nom"));
        p.setPrix(rs.getDouble("prix"));
        p.setCodeBarre(rs.getString("code_barre"));
        p.setQteStock(rs.getInt("qte_stock"));
        p.setSeuilAlerte(rs.getInt("seuil_alerte"));
        p.setCategorie(rs.getString("categorie"));
        return p;
    }

   
    public void ajouterProduit(Produit p) {
        try {
           
            String sql = "INSERT INTO produit (nom, prix, code_barre, qte_stock, seuil_alerte, categorie) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, p.getNom());
            ps.setDouble(2, p.getPrix());
            ps.setString(3, p.getCodeBarre());
            ps.setInt(4, p.getQteStock());
            ps.setInt(5, p.getSeuilAlerte());
            ps.setString(6, p.getCategorie());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) p.setId(rs.getInt(1)); 
            ps.close();
        } catch (SQLException ex) { ex.printStackTrace(); }
    }

    
    public List<Produit> getProduits() {
        List<Produit> list = new ArrayList<>();
        try {
           
            String sql = "SELECT * FROM produit"; 
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) list.add(mapResultSetToProduit(rs));
            st.close();
        } catch (SQLException ex) { ex.printStackTrace(); }
        return list;
    }

   
    public void mettreAJourProduit(Produit p) {
        try {
           
            String sql = "UPDATE produit SET nom=?, prix=?, code_barre=?, qte_stock=?, seuil_alerte=?, categorie=? WHERE id_produit=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, p.getNom());
            ps.setDouble(2, p.getPrix());
            ps.setString(3, p.getCodeBarre());
            ps.setInt(4, p.getQteStock());
            ps.setInt(5, p.getSeuilAlerte());
            ps.setString(6, p.getCategorie());
            
           
            ps.setInt(7, p.getId()); 
            
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) { ex.printStackTrace(); }
    }

  
    public void supprimerProduit(int id) {
        try {
           
            String sql = "DELETE FROM produit WHERE id_produit=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) { ex.printStackTrace(); }
    }
    
   
    public Produit getProduitById(int id) {
        try {
          
            String sql = "SELECT * FROM produit WHERE id_produit=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) return mapResultSetToProduit(rs);
        } catch(SQLException ex) { ex.printStackTrace(); }
        return null;
    }
    
   
    public List<Produit> getProduitsByNom(String nom) {
        List<Produit> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM produit WHERE nom LIKE ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + nom + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) list.add(mapResultSetToProduit(rs));
        } catch (SQLException ex) { ex.printStackTrace(); }
        return list;
    }
}
