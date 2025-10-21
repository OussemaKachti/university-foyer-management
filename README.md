# 🏠 Système de Gestion de Foyers Universitaires

## 📋 Description

Ce projet est une application Spring Boot développée dans le cadre d'un projet académique. Il s'agit d'un système de gestion de foyers universitaires qui permet de gérer les universités, foyers, blocs, chambres, étudiants et leurs réservations.

## 🏗️ Architecture

Le projet suit l'architecture en couches (4 couches) :

- **Controller** : Gestion des endpoints REST API
- **Entities** : Modèles de données JPA/Hibernate
- **Repository** : Couche d'accès aux données
- **Services** : Logique métier

## 🛠️ Technologies Utilisées

- **Spring Boot 3.5.6**
- **Spring Data JPA**
- **MySQL Database**
- **Lombok** pour la réduction du code boilerplate
- **Maven** pour la gestion des dépendances
- **Java 17**

## 📊 Modèle de Données

### Entités Principales

- **Université** : Gestion des universités
- **Foyer** : Gestion des foyers universitaires
- **Bloc** : Gestion des blocs dans un foyer
- **Chambre** : Gestion des chambres dans un bloc
- **Étudiant** : Gestion des étudiants
- **Réservation** : Gestion des réservations de chambres

### Relations

- Université ↔ Foyer (OneToOne)
- Foyer ↔ Bloc (OneToMany)
- Bloc ↔ Chambre (OneToMany)
- Chambre ↔ Réservation (OneToMany)
- Étudiant ↔ Réservation (ManyToMany)

## 🚀 Configuration

### Prérequis

- Java 17+
- Maven 3.6+
- MySQL 8.0+

### Installation

1. Cloner le repository
```bash
git clone <votre-repo-url>
cd Project
```

2. Configurer la base de données
```bash
# Créer une base de données MySQL
CREATE DATABASE SpringDB;
```

3. Configurer les propriétés dans `application.properties`
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/SpringDB?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=votre_mot_de_passe
```

4. Lancer l'application
```bash
mvn spring-boot:run
```

## 📡 API Endpoints

### Chambre Controller
- `POST /chambre/create` - Créer une chambre
- `PUT /chambre/update/{id}` - Modifier une chambre
- `DELETE /chambre/delete/{id}` - Supprimer une chambre
- `GET /chambre/getById/{id}` - Récupérer une chambre par ID
- `GET /chambre/getAll` - Récupérer toutes les chambres

## 🗄️ Base de Données

L'application utilise MySQL avec les configurations suivantes :
- Port : 3306
- Base de données : SpringDB
- Hibernate DDL : update (création automatique des tables)

## 📝 Structure du Projet

```
src/main/java/com/example/project/
├── controller/          # Contrôleurs REST
├── Entities/           # Entités JPA
├── repository/         # Repositories Spring Data
├── services/           # Services métier
└── ProjectApplication.java
```

## 🎯 Fonctionnalités

- ✅ Gestion des universités et foyers
- ✅ Gestion des blocs et chambres
- ✅ Gestion des étudiants
- ✅ Système de réservation
- ✅ API REST complète
- ✅ Architecture en couches
- ✅ Base de données relationnelle

## 👨‍💻 Développement

Ce projet a été développé dans le cadre d'un projet académique pour démontrer la maîtrise de :
- Spring Boot et Spring Data JPA
- Architecture en couches
- API REST
- Gestion de base de données relationnelle
- Bonnes pratiques de développement Java

## 📄 Licence

Projet académique - Usage éducatif uniquement
