FROM gradle:5.6.4-jdk8 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src

COPY build.gradle gradle.properties settings.gradle ./

RUN gradle bootJar -i --stacktrace



#FROM openjdk:8-jdk-alpine
FROM openjdk:8-jre-slim

WORKDIR /app

COPY --from=build /home/gradle/src/build/libs/*.jar /app/application.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/application.jar"]