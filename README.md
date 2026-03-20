# 🛒 Logiciel de Gestion pour Supérette

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![Architecture](https://img.shields.io/badge/Architecture-3--Tiers-success?style=for-the-badge)

## 📝 Description

Application de bureau (Desktop) conçue dans le cadre d'un projet universitaire en **Génie Logiciel**. Ce logiciel a pour objectif d'automatiser et de centraliser la gestion d'une surface de vente. 

Ce projet se distingue par le respect strict d'une **architecture logicielle robuste en 3 tiers** (Présentation, Logique métier, Données), garantissant un code maintenable, évolutif et sécurisé.

## 🛠️ Technologies utilisées

- **Langage & Interface :** Java / Java Swing (Interface Graphique intuitive et ergonomique).
- **Base de données :** MySQL (Modèle relationnel strict avec gestion des contraintes et clés étrangères, connexion via JDBC).
- **Conception :** Modélisation UML, Architecture Modèle 3-Tiers.

---

## ✨ Fonctionnalités principales

- 🔐 **Système d'authentification :** Gestion des accès sécurisés selon deux rôles distincts (Administrateur et Caissier).
- 📦 **Gestion des Stocks :** Opérations CRUD (Création, Lecture, Mise à jour, Suppression) sur les produits et alertes automatiques de réapprovisionnement en cas de seuil critique.
- 💳 **Module de Vente (Caisse) :** Gestion du panier client, calcul en temps réel du total et du rendu de monnaie, et décrémentation automatique des stocks lors de la validation de la commande.
- 📊 **Tableau de bord (Admin) :** Suivi du Chiffre d'Affaires total, du volume des ventes et historique transactionnel complet.

---

## 🏗️ Architecture 3-Tiers

Le projet est structuré de manière à séparer clairement les responsabilités :
1. **Couche Présentation (GUI) :** Interfaces utilisateur développées avec Java Swing.
2. **Couche Métier (Service/BLL) :** Logique de l'application (calculs, vérifications des stocks, gestion des droits).
3. **Couche Accès aux Données (DAO) :** Requêtes SQL et interaction directe avec la base de données MySQL via JDBC.
