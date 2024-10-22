FROM maven:3.9.4-eclipse-temurin-17 as build

WORKDIR /app

COPY pom.xml ./
COPY src ./src

RUN mvn clean install

FROM openjdk:17-jdk-slim

WORKDIR /app

RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

WORKDIR /app

EXPOSE 8080

CMD ["java", "-cp", "target/classes", "com.SpringLibraryApplication.class"]
