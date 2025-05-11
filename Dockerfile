FROM openjdk:21
WORKDIR /app
COPY target/art-tracker-front.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]