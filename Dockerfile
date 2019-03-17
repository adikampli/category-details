FROM openjdk:8-jdk-alpine
WORKDIR /app/category-details
COPY ./target/category-details-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "category-details-0.0.1-SNAPSHOT.jar"]