FROM openjdk:8u252-jre

USER nobody:nogroup
COPY --chown=nobody:nogroup build/libs/*.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
