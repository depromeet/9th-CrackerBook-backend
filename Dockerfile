FROM adoptopenjdk:11-jdk-hotspot AS builder
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY crackerbook-api crackerbook-api
COPY crackerbook-core crackerbook-core

RUN chmod +X ./gradlew
RUN ./gradlew bootJar

FROM adoptopenjdk:11-jdk-hotspot
COPY --from=builder crackerbook-api/build/libs/*.jar app.jar

ARG ENVIRONMENT
ENV SPRING_PROFILES_ACTIVE=${ENVIRONMENT}

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
