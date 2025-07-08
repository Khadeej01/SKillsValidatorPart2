# SKillsValidatorPart2 - Plateforme de Suivi des Compétences

## Contexte du projet

On souhaite mettre en place une application de suivi d’acquisition des compétences pour les apprenants. Cette application permettra de relier les briefs pédagogiques aux compétences attendues, tout en assurant une traçabilité des rendus des apprenants et des validations effectuées par les formateurs.

Le projet est réalisé selon une architecture microservices pour garantir la flexibilité, la scalabilité et la maintenabilité du système.

## Objectifs

- Développer une plateforme avec une architecture microservices
- Permettre aux formateurs de créer des briefs et d’y associer des compétences
- Permettre aux apprenants de déposer des rendus
- Gérer la validation des compétences sur les briefs par les formateurs

## Microservices développés

### Brief-Service
- Création de briefs pédagogiques
- Association des compétences et sous-compétences aux briefs

### Apprenant-Service
- Inscription des apprenants sur la plateforme
- Dépôt de rendus
- Consultation des rendus et des validations

### Validation-Service
- Validation des compétences par les formateurs
- Consultation des validations par les formateurs et les administrateurs
- Suivi global de l’état des compétences validées

## Technologies utilisées

- Backend : Spring Boot, Spring Data JPA
- Base de données : MySQL 
- Communication entre services : Feign Client 
- Conteneurisation : Docker et Docker Compose
- Tests unitaires : JUnit


# Diagramme de cas d'utilisation :

![Capture_decran_2025-07-07_143349](https://github.com/user-attachments/assets/12e76859-5777-4605-bf76-cf8716513ce2)

# Diagramme de class :

![image](https://github.com/user-attachments/assets/ae2ae335-304f-4cf6-89d7-29c1df62851f)

# Diagramme de sequence du Formateur :

![image](https://github.com/user-attachments/assets/6154b5f7-57ba-4b05-b316-ac5512f8b7f2)


# Diagramme de sequence du Formateur :

## Lancement du projet avec Docker

Pour démarrer tous les microservices :

```bash
docker-compose up --build


