FROM openjdk:8
EXPOSE 8081
ADD target /pi.jar pi.jar
ENTRYPOINT["java","-jar","/pi.jar"]