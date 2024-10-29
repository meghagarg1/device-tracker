# Use the latest Maven version for building the project
FROM maven:latest AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package -Dmaven.test.skip=true
FROM openjdk:17-jdk

COPY --from=build /usr/src/app/target/*SNAPSHOT.jar /app/snapshot.jar

EXPOSE 8080
ENTRYPOINT java -jar /app/snapshot.jar

