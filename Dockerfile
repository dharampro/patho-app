FROM alpine:latest
USER root
RUN mkdir app
RUN mkdir patho-app
RUN apk add maven
RUN apk add openjdk11
COPY . /patho-app
WORKDIR patho-app
RUN mvn -B package --file pom.xml
COPY target/*.jar /app/app.jar
WORKDIR /app
ENTRYPOINT ["java","-jar","/app.jar"]
