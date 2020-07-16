FROM ubuntu:rolling

RUN apt-get update && apt-get install -y --no-install-recommends openjdk-8-jre

COPY build/libs/*.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
