FROM openjdk:17-jdk-alpine as builder


WORKDIR /app/gateway-estatico-service

COPY ./pom.xml /app
COPY ./gateway-estatico-service/.mvn ./.mvn
COPY ./gateway-estatico-service/mvnw .
COPY ./gateway-estatico-service/pom.xml /app/gateway-estatico-service

#RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
RUN ./mvnw dependency:go-offline
COPY ./gateway-estatico-service/src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-alpine

WORKDIR /app
RUN mkdir ./logs
COPY --from=builder /app/gateway-estatico-service/target/gateway-estatico-service-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD ["java", "-jar", "gateway-estatico-service-0.0.1-SNAPSHOT.jar"]