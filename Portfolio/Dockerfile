# Stage 1: Build the application with Java 26
FROM maven:3.9-eclipse-temurin-26 AS build
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run the application with Java 26
FROM eclipse-temurin:26-jdk
COPY --from=build /target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
