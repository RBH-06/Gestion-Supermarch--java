/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetgl.metier;
import com.mycompany.projetgl.LigneVente;
import com.mycompany.projetgl.LigneVenteDAO;
import com.mycompany.projetgl.Produit;
import com.mycompany.projetgl.ProduitDAO;
import com.mycompany.projetgl.Vente;
import com.mycompany.projetgl.VenteDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class GestionVentes {

    private Connection connection;
    private VenteDAO venteDAO;
    private LigneVenteDAO ligneVenteDAO;
    private ProduitDAO produitDAO;

    // Constructeur
    public GestionVentes(Connection connection) {
        this.connection = connection;
        this.venteDAO = new VenteDAO(connection);
        this.ligneVenteDAO = new LigneVenteDAO(connection);
        this.produitDAO = new ProduitDAO(connection);
    }

    
    public void enregistrerVente(List<LigneVente> panier, double total, int employeId) throws Exception {
        
        try {
         
            connection.setAutoCommit(false); 

            
            Vente vente = new Vente(total, employeId);
            int venteId = venteDAO.creerVente(vente);
            
            if (venteId == -1) {
                throw new Exception("Erreur critique : Impossible de créer le ticket de vente.");
            }

           
            for (LigneVente ligne : panier) {
                
                ligne.setVenteId(venteId);
                
                
                ligneVenteDAO.ajouterLigne(ligne);
                
                
                Produit p = produitDAO.getProduitById(ligne.getProduitId());
                
                if (p != null) {
                    
                    int nouveauStock = p.getQteStock() - ligne.getQuantite();
                    
                   
                    if (nouveauStock < 0) {
                        throw new Exception("Stock insuffisant pour le produit : " + p.getNom());
                    }
                    
                    
                    p.setQteStock(nouveauStock);
                    
                   
                    produitDAO.mettreAJourProduit(p);
                }
            }

            
            connection.commit(); 
            System.out.println("Vente enregistrée avec succès !");

        } catch (Exception e) {
            
            try { 
                if (connection != null) connection.rollback(); 
                System.out.println("Annulation de la vente.");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
            throw new Exception("Échec de la vente : " + e.getMessage());
            
        } finally {
           
            try { 
                if (connection != null) connection.setAutoCommit(true); 
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}





