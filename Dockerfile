FROM openjdk:17-oracle
COPY target/hlt-food-service-0.0.1-SNAPSHOT.jar hlt-food-service-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/hlt-food-service-0.0.1-SNAPSHOT.jar"]