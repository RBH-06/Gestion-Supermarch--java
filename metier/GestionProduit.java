/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetgl.metier;


import com.mycompany.projetgl.ProduitDAO;
import com.mycompany.projetgl.Produit;
import java.sql.Connection;
import java.util.List;


public class GestionProduit {
    private ProduitDAO dao;

   
    public GestionProduit(Connection conn) {
        this.dao = new ProduitDAO(conn);
    }

    
    public void ajouterProduit(String nom, double prix, String code, int stock, int seuil, String categorie) {
        Produit p = new Produit(nom, prix, code, stock, seuil, categorie);
        dao.ajouterProduit(p);
    }

    
    public List<Produit> listerTousLesProduits() { 
        return dao.getProduits(); 
    }

    public void mettreAJourProduit(Produit p) {
        dao.mettreAJourProduit(p);
    }

    public void supprimerProduit(int id) { 
        dao.supprimerProduit(id); 
    }
    
    public Produit getProduitById(int id) { 
        return dao.getProduitById(id); 
    }
    
   
    public List<Produit> rechercherParNom(String nom) { 
     
        return dao.getProduitsByNom(nom); 
    }
}