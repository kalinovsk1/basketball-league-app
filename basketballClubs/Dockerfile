FROM eclipse-temurin:17.0.6_10-jre

ENV SERVER_PORT=8080
EXPOSE 8080

COPY target/basketballClubs-0.0.1-SNAPSHOT.jar /opt/basketball_clubs/basketball_clubs.jar

CMD ["java", "-jar", "/opt/basketball_clubs/basketball_clubs.jar"]