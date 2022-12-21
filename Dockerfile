FROM openjdk:latest

EXPOSE 5500

COPY target/moneyTransfer-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]

