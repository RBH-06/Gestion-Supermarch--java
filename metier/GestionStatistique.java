/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetgl.metier;

import com.mycompany.projetgl.VenteDAO;
import com.mycompany.projetgl.Vente;
import java.sql.Connection;
import java.util.List;

public class GestionStatistique {

    
    private VenteDAO venteDAO;

    
    public GestionStatistique(Connection connection) {
        this.venteDAO = new VenteDAO(connection);
    }

    
    public double getChiffreAffaires() {
     
        return venteDAO.getChiffreAffairesTotal();
    }

    
    public int getNombreVentes() {
        return venteDAO.getNombreVentesTotal();
    }

  
    public List<Vente> getHistorique() {
        return venteDAO.getDernieresVentes();
    }
}
