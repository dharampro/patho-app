FROM alpine:latest
USER root
RUN mkdir patho-app
RUN mkdir app
RUN	apk add maven
RUN apk add openjdk11
COPY . /patho-app
WORKDIR patho-app
RUN mvn -B package --file pom.xml
ADD target/*.jar /app/application.jar
ENTRYPOINT ["java","-jar","/app/application.jar"]
