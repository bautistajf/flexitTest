FROM openjdk:8
ARG JAR_FILE=target/*.jar
EXPOSE 8080
COPY ${JAR_FILE} fluxit-service.jar
ENTRYPOINT ["java","-jar","/fluxit-service.jar"]