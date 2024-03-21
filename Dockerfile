#FROM maven:3.8.4-openjdk-17 AS build

FROM jelastic/maven:3.9.5-openjdk-21 AS build 
WORKDIR /app

COPY . /app
RUN mvn -f /app/common-base-module install 
RUN mvn -f /app/cs544-202403-project install -DskipTests

FROM openjdk:21-jdk
WORKDIR /app

COPY --from=build /app/cs544-202403-project/target/cs544-202403-project-2.0.0-SNAPSHOT.jar project-0.0.1.jar
ENV SPRING_PROFILES_ACTIVE default

EXPOSE 8080
EXPOSE 443

ENTRYPOINT ["java", "-jar", "--add-opens", "java.base/java.lang=ALL-UNNAMED", "project-0.0.1.jar"]