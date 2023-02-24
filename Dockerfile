FROM maven:3.6.3-jdk-11 as builder
ADD pom.xml /
RUN mvn dependency:resolve-plugins
RUN mvn dependency:resolve
ADD . /
RUN mvn package spring-boot:repackage -DskipTests

FROM openjdk:18-alpine
WORKDIR /app
COPY --from=builder /target/challenge.jar .
CMD ["java", "-jar", "challenge.jar"]

EXPOSE 9090