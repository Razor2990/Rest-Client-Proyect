FROM openjdk:17.0.2-jdk

ENV TZ=America/Costa_Rica
EXPOSE 8080
COPY target/Rest-Client-Proyect.jar /deployments/app.jar
CMD ["java", "-jar", "/deployments/app.jar"]