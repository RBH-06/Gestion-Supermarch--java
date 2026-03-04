/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetgl;






public class Produit {
    private int id;
    private String nom;
    private double prix;
    private String codeBarre;
    private int qteStock;
    private int seuilAlerte;
    private String categorie; 

    public Produit() {}

    public Produit(String nom, double prix, String codeBarre, int qteStock, int seuilAlerte, String categorie) {
        this.nom = nom;
        this.prix = prix;
        this.codeBarre = codeBarre;
        this.qteStock = qteStock;
        this.seuilAlerte = seuilAlerte;
        this.categorie = categorie;
    }

   
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }
    public String getCodeBarre() { return codeBarre; }
    public void setCodeBarre(String codeBarre) { this.codeBarre = codeBarre; }
    public int getQteStock() { return qteStock; }
    public void setQteStock(int qteStock) { this.qteStock = qteStock; }
    public int getSeuilAlerte() { return seuilAlerte; }
    public void setSeuilAlerte(int seuilAlerte) { this.seuilAlerte = seuilAlerte; }
    
    
    public String getCategorie() { return categorie; }
    public void setCategorie(String categorie) { this.categorie = categorie; }
}
