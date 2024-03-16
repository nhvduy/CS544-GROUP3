FROM maven:3.8.4-openjdk-21 AS build

WORKDIR /app

COPY ./ReportingService /app
RUN mvn package

FROM openjdk:21-alpine
WORKDIR /app

COPY --from=build /app/target/*.jar ReportingService-0.0.1.jar
ENV SPRING_PROFILES_ACTIVE default

EXPOSE 443

ENTRYPOINT ["java", "-jar", "ReportingService-0.0.1.jar"]
