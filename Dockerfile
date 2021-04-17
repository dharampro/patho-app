FROM alpine:latest
USER root
RUN apk add maven
RUN apk add openjdk11
COPY . /patho-app
WORKDIR patho-app
RUN mvn -B package --file pom.xml
ARG JAR_FILE=/patho-app/target/*.jar
WORKDIR /
COPY ${JAR_FILE} /app/app.jar
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
WORKDIR /app
ENTRYPOINT ["java","-jar","/app.jar"]
