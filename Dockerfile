# First stage: build the application
FROM maven:3.8.5-openjdk-17-slim AS build
COPY . /app
WORKDIR /app
RUN mvn package -DskipTests

# Second stage: create a slim image
FROM eclipse-temurin:17-jdk-alpine
COPY --from=build /app/target/spring-soap-client-1.0.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]