FROM openjdk:17-jdk-slim

RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

WORKDIR /app

COPY . .

RUN mvn install


EXPOSE 8080

CMD ["java", "-cp", "target/classes", "com.SpringLibraryApplication.class"]
