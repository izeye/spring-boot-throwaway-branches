FROM openjdk:8u252-jdk as BUILD

COPY . source/
RUN cd source/ && ./gradlew clean bootJar

FROM openjdk:8u252-jre as RUN

USER nobody:nogroup
COPY --from=BUILD source/build/libs/*.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
