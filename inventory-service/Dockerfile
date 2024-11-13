FROM dcraig95/maven-3.6.3-jdk-17 AS build

WORKDIR /inventory-service

COPY pom.xml ./
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim

COPY --from=build /inventory-service/target/*.jar inventory-service.jar

ENTRYPOINT ["java","-jar","/inventory-service.jar"]