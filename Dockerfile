FROM openjdk:14
ADD target/Gateway.jar Gateway.jar
EXPOSE 8088
ENTRYPOINT ["java", "-jar", "Gateway.jar"]