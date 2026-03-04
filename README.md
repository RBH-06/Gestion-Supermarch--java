# 🛒 Logiciel de Gestion pour Supérette (Projet Génie Logiciel)

## Description
[cite_start]Application de bureau (Desktop) conçue pour automatiser et centraliser la gestion d'une surface de vente[cite: 215, 243]. [cite_start]Ce projet a été développé en respectant une architecture logicielle robuste en 3 tiers (Présentation, Logique métier, Données)[cite: 216, 218, 219, 220]. 

📄 **[Cliquez ici pour consulter le rapport technique complet du projet (Analyse, UML, Modèle relationnel)](Rapport_Projet_GL.pdf)**

## Technologies utilisées
* [cite_start]**Langage & Interface :** Java / Java Swing (Interface Graphique intuitive)[cite: 277].
* [cite_start]**Base de données :** MySQL (Modèle relationnel strict avec gestion des contraintes et clés étrangères)[cite: 375, 376].
* [cite_start]**Architecture :** Modèle 3-Tiers.

## Fonctionnalités principales
* [cite_start]**🔐 Système d'authentification :** Gestion des accès sécurisés selon deux rôles distincts (Administrateur et Caissier)[cite: 249, 250, 380].
* [cite_start]**📦 Gestion des Stocks :** Opérations CRUD sur les produits et alertes automatiques de réapprovisionnement en cas de seuil critique[cite: 263, 264].
* [cite_start]**💳 Module de Vente (Caisse) :** Gestion du panier client, calcul en temps réel du total et du rendu de monnaie, et décrémentation automatique des stocks lors de la validation[cite: 256, 258, 259].
* [cite_start]**📊 Tableau de bord (Admin) :** Suivi du Chiffre d'Affaires total, du volume des ventes et de l'historique transactionnel[cite: 267, 268].
