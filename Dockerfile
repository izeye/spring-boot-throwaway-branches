FROM ubuntu

RUN apt-get update
RUN apt-get install -y openjdk-8-jdk

COPY build/libs/*.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
