# Use official Maven image as build environment
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Use a smaller JRE image as runtime environment
FROM eclipse-temurin:17-jre
WORKDIR /app
# Copy the jar file to the runtime image
COPY --from=build /app/target/coincalculate-0.0.1-SNAPSHOT.jar app.jar

# Start the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8080