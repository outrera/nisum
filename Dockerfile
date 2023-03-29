# Imagen base con JDK 11
FROM openjdk:11
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY ./build/libs/NisumWsApp-0.0.1-SNAPSHOT.jar ./app.jar
EXPOSE 8080
CMD ["java","-jar","app.jar"]


# Ejecutar la aplicación Spring Boot
#CMD ["sh", "-c", "nohup java -jar /app/build/libs/NisumWsApp-0.0.1-SNAPSHOT.jar > /app/logs/app.log 2>&1 & tail -f /app/logs/app.log"]
