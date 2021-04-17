FROM alpine:latest
USER root
RUN apk add maven
RUN apk add openjdk11
RUN mkdir patho-app
COPY . /patho-app
WORKDIR patho-app
RUN mvn -B package --file pom.xml
WORKDIR /
RUN mkdir app
COPY /patho-app/target/*.jar /app/app.jar
WORKDIR /app
ENTRYPOINT ["java","-jar","/app.jar"]
