FROM alpine:latest
USER root
RUN mkdir patho-app
RUN mkdir app
RUN	apk add maven
RUN apk add openjdk11
COPY . /patho-app
WORKDIR patho-app
RUN mvn -B package --file pom.xml
RUN mv target/*.jar /app/application.jar
WORKDIR /
RUN rm -rf  patho-app
RUN apk del maven
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/application.jar"]
