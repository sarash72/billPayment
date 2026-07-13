#clean and instal project
FROM maven:3.8.7-jdk-21

#create directory
WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

#build project
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

#copy jar file to container
COPY target/billPayment-application-0.0.1-SNAPSHOT.jar app.jar


EXPOSE 8080

#run project
ENTRYPOINT ["java", "-jar", "app.jar"]