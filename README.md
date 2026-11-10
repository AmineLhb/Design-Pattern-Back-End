# Design Pattern Pizzeria — Back-End (Spring Boot)

API REST d'une application de commande de pizzas, conçue pour mettre en pratique quatre design patterns.
Projet académique réalisé à l'ENSA Fès (2022). Le front-end Angular est ici : [Design-Pattern-Front-End](https://github.com/AmineLhb/Design-Pattern-Front-End).

## Design patterns utilisés

| Pattern | Où | Rôle |
|---|---|---|
| **Abstract Factory** | `Fabriquer/`, `Factory/` | Chaque restaurant (Fès, Meknès) fabrique ses propres variantes de pizzas (fromage, fruits de mer, mixte, quatre saisons). |
| **Observer** | `Pizzeria/Pizzeria.java` | La pizzeria notifie ses observateurs à chaque commande préparée. |
| **Adapter** | `Adapter/` | Conversion du prix dans différentes devises (euro, dollar) derrière une interface commune. |
| **Injection de dépendances** | `controller/`, `service/` | Les contrôleurs et services sont injectés par Spring. |

## Fonctionnalités

- Inscription et gestion des chefs (création, modification, suppression).
- Passage d'une commande : client, type de pizza, restaurant et chef.
- Persistance des chefs, clients et commandes avec Spring Data JPA.

## Endpoints principaux

| Méthode | URL | Description |
|---|---|---|
| GET | `/chefs` | Liste des chefs |
| GET | `/chefs/{id}` | Détail d'un chef |
| POST | `/register` | Inscription d'un chef |
| PUT | `/showFormForUpdate/{id}` | Modification d'un chef |
| DELETE | `/deleteChef/{id}` | Suppression d'un chef |
| POST | `/save-commande` | Enregistrement d'une commande |

## Stack

Java, Spring Boot 2.7, Spring Web, Spring Data JPA, MySQL, Lombok, Maven.

## Lancer le projet

1. Créer une base MySQL `designpattern` (identifiants dans `src/main/resources/application.properties`).
2. Démarrer l'API :
   ```bash
   ./mvnw spring-boot:run
   ```
3. L'API écoute sur `http://localhost:8080`.
