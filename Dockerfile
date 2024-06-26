FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:19-ea-19-jdk-slim
COPY --from=build /target/ner-Application-0.0.1-SNAPSHOT.jar demo.jar
EXPOSE 8081

ENTRYPOINT ["java", "-jar", "-Xmx256m", "demo.jar"]
