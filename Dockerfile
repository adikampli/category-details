FROM openjdk:8-jdk-alpine
WORKDIR /app/category-details
EXPOSE 6226
COPY ./.mvn/ ./.mvn
COPY ./pom.xml .
COPY mvnw .
COPY ./src/ ./src
RUN ./mvnw package
ENTRYPOINT ["java", "-jar", "./target/category-details-0.0.1-SNAPSHOT.jar"]