# Dockerfile
FROM amazoncorretto:21
VOLUME /tmp

COPY ui/target/ui-0.0.1-SNAPSHOT.jar /app/ui.jar

ENTRYPOINT ["java", "-jar", "/app/ui.jar"]



