FROM maven:3.8.5-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src /app/src
RUN mvn clean package -DskipTests
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

COPY --from=build /app/target/springlibrary-0.0.1-SNAPSHOT.jar /app/springlibrary.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/springlibrary.jar"]
