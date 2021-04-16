FROM openjdk:17-jdk-alpine3.13
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=k8s-webapp-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]