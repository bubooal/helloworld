FROM openjdk:8-jdk-alpine

WORKDIR /app

ADD ./target/helloworld-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8081

VOLUME /tmp

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/app.jar"]
