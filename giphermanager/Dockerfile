FROM java:8-jre
ADD ./target/giphermanager-1.0.jar giphermanager/src/giphermanager-1.0.jar
WORKDIR accountmanager/src
ENTRYPOINT ["java", "-jar", "giphermanager-1.0.jar"]