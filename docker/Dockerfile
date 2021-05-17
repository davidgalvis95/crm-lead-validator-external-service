FROM openjdk:11-jre-slim
VOLUME /tmp
ARG JAR_FILE
EXPOSE 8000
COPY *.jar lead_validation.jar
ENTRYPOINT ["java","-jar","/external_service.jar"]