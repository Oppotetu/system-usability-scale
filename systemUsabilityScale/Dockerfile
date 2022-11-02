FROM adoptopenjdk/openjdk11:alpine-jre
WORKDIR C:/Users/simon/Prosjekter/systemUsabilityScale/systemUsabilityScale
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} target/systemUsabilityScale-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","target/systemUsabilityScale-0.0.1-SNAPSHOT.jar"]
