FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY ./target/opentrends-createBuild-0.0.1-SNAPSHOT.jar app.jar
ARG JAR_FILE=target/*.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","/app.jar"]