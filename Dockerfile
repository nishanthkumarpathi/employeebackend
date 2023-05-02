#
# Build stage
#
FROM openjdk:17-jdk-slim AS build
COPY . .
RUN mvnw package -DskipTests

#
# Package stage
#
FROM openjdk:17-jdk-slim
COPY --from=build /target/employeebackend-0.0.1-SNAPSHOT.jar employeebackend.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","employeebackend.jar"]