FROM maven:3.8.2-jdk-11
WORKDIR ../projeto-integrador
COPY . .
CMD mvn spring-boot:run
