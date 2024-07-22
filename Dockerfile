FROM openjdk:17.0.2-jdk
#FROM registry.access.redhat.com/ubi9/openjdk-17 
#USER root
#RUN mkdir -p /var/cache/yum/metadata && microdnf -y update
ENV TZ=America/Costa_Rica
EXPOSE 8080
COPY target/Rest-Client-Proyect.jar app.jar
CMD ["java", "-jar", "app.jar"]