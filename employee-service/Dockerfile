FROM openjdk:17-jdk-alpine as builder

WORKDIR /app/employee-service

COPY ./pom.xml /app
COPY ./employee-service/.mvn ./.mvn
COPY ./employee-service/mvnw .
COPY ./employee-service/pom.xml .

#RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
RUN ./mvnw dependency:go-offline
COPY ./employee-service/src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-alpine

WORKDIR /app
RUN mkdir ./logs
COPY --from=builder /app/employee-service/target/employee-service-0.0.1-SNAPSHOT.jar .
EXPOSE 8001
#CMD sleep 10 && java -jar employee-service-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "employee-service-0.0.1-SNAPSHOT.jar"]