FROM openjdk:17-jdk-slim

RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

WORKDIR /app

COPY . .

RUN mvn clean install || true


EXPOSE 8080

CMD ["java", "-cp", "src/main/java/com/bet/springlibrary", "SpringLibraryApplication.java"]
