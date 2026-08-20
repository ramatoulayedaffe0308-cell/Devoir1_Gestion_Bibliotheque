# 📚 Devoir1 — Gestion de Bibliothèque

## 📌 Description

**Devoir1** est une application Java de gestion de bibliothèque développée dans le cadre de la formation en **Génie Logiciel**.

L'application permet de gérer les utilisateurs, les livres et les emprunts à travers une interface en ligne de commande.

Elle utilise une base de données **MySQL** et la technologie **JDBC** pour assurer la communication entre l'application Java et la base de données.

---

## 🚀 Fonctionnalités

### 🔐 Authentification

L'application possède un système d'authentification permettant aux utilisateurs de se connecter avec :

- Email
- Mot de passe
- Rôle

Deux rôles sont disponibles :

- 👨‍💼 **Administrateur**
- 👩‍💼 **Gestionnaire**

---

### 👨‍💼 Fonctionnalités Administrateur

L'administrateur peut :

- ➕ Ajouter un utilisateur
- 📋 Afficher tous les utilisateurs
- 🔎 Rechercher un utilisateur
- ➕ Ajouter un livre
- 📚 Afficher tous les livres
- 🔓 Se déconnecter

---

### 👩‍💼 Fonctionnalités Gestionnaire

Le gestionnaire peut :

- ➕ Enregistrer un emprunt
- 📋 Afficher les emprunts
- 🔄 Retourner un livre
- 🔓 Se déconnecter

Lorsqu'un livre est retourné :

- son statut de disponibilité est mis à jour ;
- la date de retour est enregistrée ;
- son emprunt peut être considéré comme terminé.

---

## 🛠️ Technologies utilisées

| Technologie | Utilisation |
|---|---|
| ☕ Java | Langage de programmation |
| 🗄️ MySQL | Base de données |
| 🔌 JDBC | Connexion Java / MySQL |
| 💻 IntelliJ IDEA | Environnement de développement |
| 🌐 Git / GitHub | Gestion de versions |

---

## 🏗️ Architecture du projet

Le projet utilise une organisation basée sur les modèles, les interfaces et les DAO.

```text
Devoir1/
│
├── src/
│   ├── DAO/
│   │   └── BD/
│   │       ├── AdminDAO.java
│   │       ├── AuthentifierDAO.java
│   │       ├── DB_Connexion.java
│   │       ├── GestionnaireDAO.java
│   │       └── Session.java
│   │
│   ├── models/
│   │   ├── Emprunt.java
│   │   ├── Livre.java
│   │   └── Utilisateur.java
│   │
│   ├── repositories/
│   │   ├── InterfaceAdmin.java
│   │   └── InterfaceGest.java
│   │
│   └── Main.java
│
├── .gitignore
└── README.md