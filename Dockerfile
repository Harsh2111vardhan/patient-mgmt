# Use Maven to build
FROM maven:3.9.6-eclipse-temurin-21 AS builder

WORKDIR /app

# Copy source code
COPY . .

# Build the application
RUN mvn clean package -DskipTests

# ==============================
# Production stage
FROM openjdk:21-jdk-slim

WORKDIR /app

# Copy the jar from the builder stage
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

# Start the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
