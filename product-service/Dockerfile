# Temel imaj olarak dcraig95/maven-3.6.3-jdk-17 kullanın
FROM dcraig95/maven-3.6.3-jdk-17 AS build

# Çalışma dizinini ayarlayın
WORKDIR /product-service

# Pom.xml dosyasını kopyalayın ve bağımlılıkları indirin
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Uygulamayı çalıştırmak için JDK imajını kullanın
FROM openjdk:17-jdk-slim

# Jar dosyasını kopyalayın
COPY --from=build /product-service/target/*.jar product-service.jar

# Uygulamayı çalıştırın
ENTRYPOINT ["java","-jar","/product-service.jar"]