### BUILD STAGE ###
FROM maven:3.8.5-openjdk-11-slim AS BUILD_STAGE
COPY pom.xml /build/
COPY src /build/src
WORKDIR /build
RUN mvn clean install

### PACKAGING STAGE ###
FROM openjdk:11-oracle
COPY --from=BUILD_STAGE /build/target/desafio-0.0.1-SNAPSHOT.jar desafio.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","desafio.jar"]