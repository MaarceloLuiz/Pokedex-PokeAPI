FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
COPY assets ./assets
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jdk
WORKDIR /app
RUN apt-get update && \
    apt-get install -y libgtk-3-0 libx11-xcb1 libxtst6 libxrandr2 libxrender1 libxi6 libfreetype6 libfontconfig1 libgl1 maven && \
    rm -rf /var/lib/apt/lists/*
COPY . .
CMD ["mvn", "javafx:run"]