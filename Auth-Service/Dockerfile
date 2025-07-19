# Utilise une image Java officielle légère
FROM eclipse-temurin:17-jdk-alpine

# Crée un répertoire de travail
WORKDIR /app

# Copie le jar généré par Maven
COPY target/Auth-Service-0.0.1-SNAPSHOT.jar app.jar

# Expose le port 8080
EXPOSE 8080

# Commande de lancement
ENTRYPOINT ["java", "-jar", "app.jar"] 