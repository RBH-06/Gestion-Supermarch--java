/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetgl; 


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import java.util.Date; 

public class Vente {
    private int id;
    private double montantTotal;
    private int employeId;
    private Date dateVente; 

    public Vente() {
    }

    
    public Vente(double montantTotal, int employeId) {
        this.montantTotal = montantTotal;
        this.employeId = employeId;
    }

   
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public double getMontantTotal() { return montantTotal; }
    public void setMontantTotal(double montantTotal) { this.montantTotal = montantTotal; }

    public int getEmployeId() { return employeId; }
    public void setEmployeId(int employeId) { this.employeId = employeId; }
    
   
    public Date getDateVente() { return dateVente; }
    public void setDateVente(Date dateVente) { this.dateVente = dateVente; }
}