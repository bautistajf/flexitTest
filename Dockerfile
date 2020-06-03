FROM openjdk:8
VOLUME /tmp
EXPOSE 8081
ADD ./target/flexit-0.0.1-SNAPSHOT.jar fluxit-service.jar
ENTRYPOINT ["java","-jar","/fluxit-service.jar"]