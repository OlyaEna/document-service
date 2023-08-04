FROM amazoncorretto:17-alpine-jdk
COPY build/libs/document-service-0.0.1-SNAPSHOT.jar document-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/document-service-0.0.1-SNAPSHOT.jar"]