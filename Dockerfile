FROM openjdk:11
ARG JAR_FILE=build/libs/eurekadiscovery-app.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8761:8761
ENTRYPOINT ["java","-Duser.timezone=UTC","-jar","app.jar"]