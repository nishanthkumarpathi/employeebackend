# Build Stage
FROM openjdk:21-ea-17-slim-buster AS build
RUN mkdir app
WORKDIR app
COPY . .
RUN chmod +x mvnw
RUN ./mvnw package -DskipTests

#
# Package stage
#
FROM openjdk:21-ea-17-slim-buster
COPY --from=build /app/target/employeebackend-0.0.1-SNAPSHOT.jar employeebackend.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","employeebackend.jar"]