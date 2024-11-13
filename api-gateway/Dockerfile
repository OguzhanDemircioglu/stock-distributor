FROM dcraig95/maven-3.6.3-jdk-17 AS build

WORKDIR /gateway

COPY pom.xml ./
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim

COPY --from=build /gateway/target/*.jar gateway.jar

ENTRYPOINT ["java", "-jar", "/gateway.jar"]
