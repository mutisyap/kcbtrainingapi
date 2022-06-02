FROM adoptopenjdk/openjdk11

COPY ./target/*.jar /apps/app.jar

ENTRYPOINT ["java", "-jar", "/apps/app.jar"]

EXPOSE 8080

# docker build -t pmutisya/kcbapi .
