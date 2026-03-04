/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetgl;

public class LigneVente {
 
    private int id;
    private int venteId;
    private int produitId;
    private String nomProduit; 
    private int quantite;
    private double prixUnitaire;

    public LigneVente(int produitId, String nomProduit, int quantite, double prixUnitaire) {
        this.produitId = produitId;
        this.nomProduit = nomProduit;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
    }

    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public int getVenteId() { return venteId; }
    public void setVenteId(int venteId) { this.venteId = venteId; }
    
    public int getProduitId() { return produitId; }
    public void setProduitId(int produitId) { this.produitId = produitId; }
    
    public String getNomProduit() { return nomProduit; }
    
    public int getQuantite() { return quantite; }
    public void setQuantite(int quantite) { this.quantite = quantite; }
    
    public double getPrixUnitaire() { return prixUnitaire; }
    public void setPrixUnitaire(double prixUnitaire) { this.prixUnitaire = prixUnitaire; }
    
    
    public double getSousTotal() { return quantite * prixUnitaire; }
}
