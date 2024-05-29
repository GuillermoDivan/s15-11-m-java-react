# CONSTRUCCION DE DOCKER
FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/Ticketcine-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_ticketcine.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "app_ticketcine" ]