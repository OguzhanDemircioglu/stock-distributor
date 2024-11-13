FROM dcraig95/maven-3.6.3-jdk-17 AS build

WORKDIR /order-service

COPY pom.xml ./
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim

COPY --from=build /order-service/target/*.jar order-service.jar

ENTRYPOINT ["java", "-jar", "/order-service.jar"]
